-- DROP TABLE IF EXISTS product;
--
-- CREATE TABLE `product` (
--     `id` integer AUTO_INCREMENT  PRIMARY KEY,
--     `category` varchar(100) NOT NULL,
--     `create_time` date DEFAULT NOT NULL,
--     `name` varchar(100) NOT NULL,
--     `vendor` varchar(100) NOT NULL
-- );

INSERT INTO `product` (`category`, `create_time`, `name`, `vendor` )
VALUES ('Sneaker', CURDATE(),'Nike Air-123', 'Nike');