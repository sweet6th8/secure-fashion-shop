-- Tạo Database
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'webSQL')
BEGIN
    CREATE DATABASE webSQL;
END;
GO

USE webSQL;

-- Bắt đầu giao dịch
BEGIN TRANSACTION;

-- 1. Bảng loại nội dung
CREATE TABLE content_types (
    id INT IDENTITY(1,1) PRIMARY KEY,
    app_label NVARCHAR(100) NOT NULL,
    model NVARCHAR(100) NOT NULL
);

-- 2. Bảng quyền
CREATE TABLE permissions (
    id INT IDENTITY(1,1) PRIMARY KEY,
    content_type_id INT NOT NULL FOREIGN KEY REFERENCES content_types(id),
    codename NVARCHAR(100) NOT NULL,
    permission_name NVARCHAR(255) NOT NULL
);

-- 3. Bảng nhóm người dùng
CREATE TABLE user_groups (
    id INT IDENTITY(1,1) PRIMARY KEY,
    group_name NVARCHAR(150) NOT NULL UNIQUE
);

-- 4. Bảng người dùng
CREATE TABLE users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    password NVARCHAR(128) NOT NULL,
    last_login DATETIME NULL,
    is_superuser BIT NOT NULL,
    username NVARCHAR(150) NOT NULL UNIQUE,
    last_name NVARCHAR(150) NOT NULL,
    email NVARCHAR(254) NOT NULL,
    is_staff BIT NOT NULL,
    is_active BIT NOT NULL,
    date_joined DATETIME NOT NULL,
    first_name NVARCHAR(150) NOT NULL
);

-- 5. Bảng nhóm quyền (liên kết giữa user_groups và permissions)
CREATE TABLE group_permissions (
    id INT IDENTITY(1,1) PRIMARY KEY,
    group_id INT NOT NULL FOREIGN KEY REFERENCES user_groups(id),
    permission_id INT NOT NULL FOREIGN KEY REFERENCES permissions(id)
);

-- 6. Bảng quyền người dùng (liên kết giữa users và permissions)
CREATE TABLE user_permissions (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL FOREIGN KEY REFERENCES users(id),
    permission_id INT NOT NULL FOREIGN KEY REFERENCES permissions(id)
);

-- 7. Bảng nhóm của người dùng (liên kết giữa users và user_groups)
CREATE TABLE user_group_memberships (
    id INT IDENTITY(1,1) PRIMARY KEY,
    user_id INT NOT NULL FOREIGN KEY REFERENCES users(id),
    group_id INT NOT NULL FOREIGN KEY REFERENCES user_groups(id)
);

-- 8. Bảng danh mục sản phẩm
CREATE TABLE product_categories (
    id INT IDENTITY(1,1) PRIMARY KEY,
    category_name NVARCHAR(50) NOT NULL UNIQUE,
    slug NVARCHAR(100) NOT NULL UNIQUE,
    description NVARCHAR(MAX) NOT NULL,
    category_image NVARCHAR(100) NOT NULL
);

-- 9. Bảng sản phẩm (liên kết đến product_categories)
CREATE TABLE products (
    id INT IDENTITY(1,1) PRIMARY KEY,
    product_name NVARCHAR(200) NOT NULL UNIQUE,
    slug NVARCHAR(200) NOT NULL UNIQUE,
    description NVARCHAR(MAX) NOT NULL,
    price INT NOT NULL,
    images NVARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    is_available BIT NOT NULL,
    created_date DATETIME NOT NULL,
    modified_date DATETIME NOT NULL,
    category_id INT NOT NULL FOREIGN KEY REFERENCES product_categories(id)
);

-- 10. Bảng phiên làm việc của người dùng
CREATE TABLE user_sessions (
    session_key NVARCHAR(40) NOT NULL PRIMARY KEY,
    session_data NVARCHAR(MAX) NOT NULL,
    expire_date DATETIME NOT NULL
);

-- 11. Bảng nhật ký quản trị (liên kết đến content_types và users)
CREATE TABLE admin_logs (
    id INT IDENTITY(1,1) PRIMARY KEY,
    object_id NVARCHAR(MAX) NULL,
    object_representation NVARCHAR(200) NOT NULL,
    action_flag TINYINT NOT NULL CHECK (action_flag >= 0),
    change_message NVARCHAR(MAX) NOT NULL,
    content_type_id INT NULL FOREIGN KEY REFERENCES content_types(id),
    user_id INT NOT NULL FOREIGN KEY REFERENCES users(id),
    action_time DATETIME NOT NULL
);

-- 12. Bảng nhật ký hệ thống
CREATE TABLE system_migrations (
    id INT IDENTITY(1,1) PRIMARY KEY,
    app NVARCHAR(255) NOT NULL,
    name NVARCHAR(255) NOT NULL,
    applied DATETIME NOT NULL
);

-- Kết thúc giao dịch
COMMIT;
