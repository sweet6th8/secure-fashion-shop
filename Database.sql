CREATE DATABASE ClothingShopWeb;
-- Tạo bảng User
CREATE TABLE [User] (
    id INT PRIMARY KEY IDENTITY(1,1), -- ID tự tăng
    username NVARCHAR(50) NOT NULL UNIQUE, -- Tên đăng nhập (duy nhất)
    password NVARCHAR(255) NOT NULL, -- Mật khẩu
    email NVARCHAR(255) UNIQUE, -- Địa chỉ email (duy nhất)
    fullName NVARCHAR(255), -- Họ và tên
    address NVARCHAR(255), -- Địa chỉ
    phone NVARCHAR(20), -- Số điện thoại
    gender BIT NOT NULL -- Giới tính (0 - Nữ, 1 - Nam)
);

-- Tạo bảng Category
CREATE TABLE Category (
    id INT PRIMARY KEY IDENTITY(1,1), -- ID tự tăng
    title NVARCHAR(255) NOT NULL, -- Tên danh mục
    description NVARCHAR(MAX) -- Mô tả danh mục
);

-- Tạo bảng Product
CREATE TABLE Product (
    id INT PRIMARY KEY IDENTITY(1,1), -- ID tự tăng
    name NVARCHAR(255) NOT NULL, -- Tên sản phẩm
    description NVARCHAR(MAX), -- Mô tả sản phẩm
    photo NVARCHAR(255), -- URL ảnh sản phẩm
    price DECIMAL(18, 2) NOT NULL, -- Giá sản phẩm
    discount DECIMAL(18, 2) NOT NULL, -- Giảm giá
    category_id INT, -- ID danh mục sản phẩm
    FOREIGN KEY (category_id) REFERENCES Category(id) -- Khóa ngoại tới Category
);

-- Insert sample clothing categories
INSERT INTO Category (title, description) VALUES
('Men''s Clothing', 'A variety of clothing options for men including shirts, pants, and outerwear.'),
('Women''s Clothing', 'Stylish and comfortable clothing options for women including dresses, tops, and skirts.'),
('Kids'' Clothing', 'Trendy and durable clothing for kids of all ages.');

-- Insert sample products related to clothing
INSERT INTO Product (name, description, photo, price, discount, category_id) VALUES
('Men''s Casual Shirt', 'A comfortable cotton shirt for everyday wear.', '/static/images/products/mens_casual_shirt.jpg', 29.99, 5.00, 1),
('Men''s Denim Jacket', 'Classic denim jacket that goes with any outfit.', '/static/images/products/mens_denim_jacket.jpg', 49.99, 10.00, 1),
('Women''s Summer Dress', 'Lightweight summer dress perfect for hot weather.', '/static/images/products/womens_summer_dress.jpg', 49.99, 10.00, 2),
('Women''s Blouse', 'Elegant blouse suitable for work or casual outings.', '/static/images/products/womens_blouse.jpg', 39.99, 8.00, 2),
('Kids'' T-Shirt', 'Fun and colorful t-shirt for kids.', '/static/images/products/kids_tshirt.jpg', 19.99, 3.00, 3),
('Kids'' Hoodie', 'Cozy hoodie to keep kids warm in cooler weather.', '/static/images/products/kids_hoodie.jpg', 29.99, 5.00, 3);

INSERT INTO Product (name, description, photo, price, discount, category_id) VALUES
('Men''s Casual Shirt', 'A comfortable cotton shirt for everyday wear.', '/static/images/products/mens_casual_shirt.jpg', 29.99, 5.00, 1),
('Men''s Denim Jacket', 'Classic denim jacket that goes with any outfit.', '/static/images/products/mens_denim_jacket.jpg', 49.99, 10.00, 1),
('Men''s Formal Pants', 'Slim fit formal pants suitable for office wear.', '/static/images/products/mens_formal_pants.jpg', 39.99, 7.00, 1),
('Women''s Summer Dress', 'Lightweight summer dress perfect for hot weather.', '/static/images/products/womens_summer_dress.jpg', 49.99, 10.00, 2),
('Women''s Blouse', 'Elegant blouse suitable for work or casual outings.', '/static/images/products/womens_blouse.jpg', 39.99, 8.00, 2),
('Women''s Leather Jacket', 'Stylish leather jacket for a chic look.', '/static/images/products/womens_leather_jacket.jpg', 99.99, 15.00, 2),
('Kids'' T-Shirt', 'Fun and colorful t-shirt for kids.', '/static/images/products/kids_tshirt.jpg', 19.99, 3.00, 3),
('Kids'' Hoodie', 'Cozy hoodie to keep kids warm in cooler weather.', '/static/images/products/kids_hoodie.jpg', 29.99, 5.00, 3),
('Kids'' Sneakers', 'Comfortable sneakers for active children.', '/static/images/products/kids_sneakers.jpg', 39.99, 6.00, 3);
	
SELECT * FROM Category WHERE id = 1;

SELECT * FROM Product
ORDER BY id
OFFSET 0 ROWS
FETCH NEXT 2 ROWS ONLY;

