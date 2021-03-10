CREATE TABLE mysql.idus_order (
	number varchar(10) PRIMARY KEY,
	product_name varchar(100) NOT NULL,
	order_date datetime NOT NULL,
	user_number bigint NOT NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci;