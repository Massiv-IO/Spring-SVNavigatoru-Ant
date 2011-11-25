CREATE TABLE products (
	id INTEGER NOT NULL PRIMARY KEY,
	description VARCHAR(100) NOT NULL,
	price DECIMAL(15, 2) NOT NULL
);

CREATE INDEX products_description ON products(description);
