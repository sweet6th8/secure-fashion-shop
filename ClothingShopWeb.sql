CREATE
DATABASE ClothingShopWeb;
USE
master;
GO
ALTER
DATABASE ClothingShopWeb SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
GO
DROP
DATABASE ClothingShopWeb;
USE
ClothingShopWeb
-- Tạo bảng User

SELECT *
FROM ListUser
SELECT *
FROM Product
SELECT *
FROM Carts
DELETE
FROM Carts
SELECT *
FROM carts
WHERE user_id = 1;
SELECT *
FROM cart_items
WHERE cart_id = 7;
SELECT *
FROM Product;
-- Tạo bảng Category
CREATE TABLE Categories
(
    id          INT PRIMARY KEY IDENTITY(1,1), -- ID tự tăng
    title       NVARCHAR(255) NOT NULL,        -- Tên danh mục
    description NVARCHAR(MAX)                  -- Mô tả danh mục
);


-- Tạo bảng Product
CREATE TABLE Product
(
    id          INT PRIMARY KEY IDENTITY(1,1),              -- ID tự tăng
    name        NVARCHAR(255) NOT NULL,                     -- Tên sản phẩm
    description NVARCHAR(MAX),                              -- Mô tả sản phẩm
    photo       NVARCHAR(255),                              -- URL ảnh sản phẩm
    price       DECIMAL(18, 2) NOT NULL,                    -- Giá sản phẩm
    stock       INT            NOT NULL CHECK (stock >= 0), -- Số lượng tồn kho (không âm)
    category_id INT,                                        -- Liên kết danh mục sản phẩm
    FOREIGN KEY (category_id) REFERENCES Categories (id)    -- Khóa ngoại tới bảng Category
);
CREATE TABLE Carts
(
    id         INT PRIMARY KEY IDENTITY(1,1), -- ID tự tăng
    user_id    INT NOT NULL,                  -- ID người dùng (liên kết với bảng User, nếu có)
    created_at DATETIME DEFAULT GETDATE(),    -- Thời gian tạo
    updated_at DATETIME DEFAULT GETDATE()     -- Thời gian cập nhật
);

CREATE TABLE Cart_items
(
    id         INT PRIMARY KEY IDENTITY(1,1),                          -- ID tự tăng
    cart_id    INT NOT NULL,                                           -- Liên kết giỏ hàng
    product_id INT NOT NULL,                                           -- Liên kết sản phẩm
    quantity   INT NOT NULL CHECK (quantity > 0),                      -- Số lượng sản phẩm (lớn hơn 0)
    created_at DATETIME DEFAULT GETDATE(),                             -- Thời gian thêm vào giỏ hàng
    updated_at DATETIME DEFAULT GETDATE(),                             -- Thời gian cập nhật mục
    FOREIGN KEY (cart_id) REFERENCES Carts (id) ON DELETE CASCADE,     -- Liên kết giỏ hàng
    FOREIGN KEY (product_id) REFERENCES Product (id) ON DELETE CASCADE -- Liên kết sản phẩm
);


CREATE TABLE [dbo].[ListUser]
(
    [
    id]
    INT
    IDENTITY
(
    1,
    1
) NOT NULL, -- Tự động tăng ID
    [username] NVARCHAR
(
    50
) NOT NULL, -- Tên người dùng (không được trống)
    [password] NVARCHAR
(
    255
) NOT NULL, -- Mật khẩu (không được trống)
    [email] NVARCHAR
(
    255
) NULL, -- Email (cho phép trống)
    [fullName] NVARCHAR
(
    255
) NULL, -- Họ và tên (cho phép trống)
    [address] NVARCHAR
(
    255
) NULL, -- Địa chỉ (cho phép trống)
    [phone] NVARCHAR
(
    20
) NULL, -- Số điện thoại (cho phép trống)
    [gender] BIT NOT NULL, -- Giới tính (1 = Nam, 0 = Nữ, không được trống)

    PRIMARY KEY CLUSTERED
(
[
    id]
    ASC
), -- Khóa chính dạng Clustered
    UNIQUE NONCLUSTERED
(
[
    email]
    ASC
), -- Email là duy nhất, không trùng
    UNIQUE NONCLUSTERED
(
[
    username]
    ASC
) -- Username là duy nhất, không trùng
    ) ON [PRIMARY];

CREATE TABLE Orders
(
    id          INT PRIMARY KEY IDENTITY(1,1),      -- ID đơn hàng (auto increment)
    user_id     INT            NOT NULL,            -- Người tạo đơn hàng (liên kết với bảng User)
    total_price DECIMAL(18, 2) NOT NULL,            -- Tổng số tiền
    status      NVARCHAR(50) NOT NULL,              -- Trạng thái đơn hàng (Pending, Paid, Cancelled...)
    created_at  DATETIME DEFAULT GETDATE(),         -- Thời gian tạo
    updated_at  DATETIME DEFAULT GETDATE(),         -- Thời gian cập nhật
    FOREIGN KEY (user_id) REFERENCES [ListUser](id) -- Khóa ngoại tới bảng User
);

CREATE TABLE Order_Items
(
    id         INT PRIMARY KEY IDENTITY(1,1),                        -- ID tự tăng
    order_id   INT            NOT NULL,                              -- Tham chiếu đến bảng Orders
    product_id INT            NOT NULL,                              -- Tham chiếu đến bảng Product
    quantity   INT            NOT NULL,                              -- Số lượng sản phẩm
    price      DECIMAL(18, 2) NOT NULL,                              -- Giá sản phẩm tại thời điểm mua
    FOREIGN KEY (order_id) REFERENCES Orders (id) ON DELETE CASCADE, -- Liên kết đơn hàng
    FOREIGN KEY (product_id) REFERENCES Product (id)                 -- Liên kết sản phẩm
);

SELECT *
FROM Orders;
SELECT *
FROM Order_Items;

-- Insert sample clothing categories
INSERT INTO Categories (title, description)
VALUES ('Men''s Clothing', 'A variety of clothing options for men including shirts, pants, and outerwear.'),
       ('Women''s Clothing', 'Stylish and comfortable clothing options for women including dresses, tops, and skirts.'),
       ('Kids'' Clothing', 'Trendy and durable clothing for kids of all ages.');

-- Insert sample products related to clothing
INSERT INTO Product (name, description, photo, price, stock, category_id)
VALUES ('Men''s Casual Shirt', 'A comfortable cotton shirt for everyday wear.',
        '/static/images/products/mens_casual_shirt.jpg', 29.99, 5, 1),
       ('Men''s Denim Jacket', 'Classic denim jacket that goes with any outfit.',
        '/static/images/products/mens_denim_jacket.jpg', 49.99, 10, 1),
       ('Women''s Summer Dress', 'Lightweight summer dress perfect for hot weather.',
        '/static/images/products/womens_summer_dress.jpg', 49.99, 10, 2),
       ('Women''s Blouse', 'Elegant blouse suitable for work or casual outings.',
        '/static/images/products/womens_blouse.jpg', 39.99, 8, 2),
       ('Kids'' T-Shirt', 'Fun and colorful t-shirt for kids.', '/static/images/products/kids_tshirt.jpg', 19.99, 3, 3),
       ('Kids'' Hoodie', 'Cozy hoodie to keep kids warm in cooler weather.', '/static/images/products/kids_hoodie.jpg',
        29.99, 5, 3);

INSERT INTO Product (name, description, photo, price, stock, category_id)
VALUES ('Men''s Casual Shirt', 'A comfortable cotton shirt for everyday wear.',
        '/static/images/products/mens_casual_shirt.jpg', 29.99, 5, 1),
       ('Men''s Denim Jacket', 'Classic denim jacket that goes with any outfit.',
        '/static/images/products/mens_denim_jacket.jpg', 49.99, 10, 1),
       ('Men''s Formal Pants', 'Slim fit formal pants suitable for office wear.',
        '/static/images/products/mens_formal_pants.jpg', 39.99, 7, 1),
       ('Women''s Summer Dress', 'Lightweight summer dress perfect for hot weather.',
        '/static/images/products/womens_summer_dress.jpg', 49.99, 10, 2),
       ('Women''s Blouse', 'Elegant blouse suitable for work or casual outings.',
        '/static/images/products/womens_blouse.jpg', 39.99, 8, 2),
       ('Women''s Leather Jacket', 'Stylish leather jacket for a chic look.',
        '/static/images/products/womens_leather_jacket.jpg', 99.99, 15, 2),
       ('Kids'' T-Shirt', 'Fun and colorful t-shirt for kids.', '/static/images/products/kids_tshirt.jpg', 19.99, 3, 3),
       ('Kids'' Hoodie', 'Cozy hoodie to keep kids warm in cooler weather.', '/static/images/products/kids_hoodie.jpg',
        29.99, 5, 3),
       ('Kids'' Sneakers', 'Comfortable sneakers for active children.', '/static/images/products/kids_sneakers.jpg',
        39.99, 6, 3);



SELECT *
FROM CartItem

SELECT *
FROM ListUser
