-- To run the script execute the command below
-- psql -U postgres -f setup_db.sql

-- Create the database
CREATE DATABASE product_store;

-- Connect to the newly created database
\c product_store;


-- Grant all privileges on the new database to the new user
GRANT ALL PRIVILEGES ON DATABASE product_store TO postgres;

-- Create the users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);


-- Create the products table
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price NUMERIC(10, 2) NOT NULL
);

-- Create the reviews table
CREATE TABLE reviews (
    id SERIAL PRIMARY KEY,
    rating INTEGER NOT NULL,
    comment TEXT,
    user_id INTEGER NOT NULL REFERENCES users(id),
    product_id INTEGER NOT NULL REFERENCES products(id)
);

 GRANT ALL PRIVILEGES ON TABLE users TO postgres;
 GRANT ALL PRIVILEGES ON TABLE products TO postgres;
 GRANT ALL PRIVILEGES ON TABLE  reviews TO postgres;


-- TEMPORARY only just to add some data
-- Insert sample data into users table
INSERT INTO users (username, email) VALUES ('john_doe', 'john_doe@example.com');
INSERT INTO users (username, email) VALUES ('jane_smith', 'jane_smith@example.com');

-- Insert sample data into products table
INSERT INTO products (name, description, price) VALUES ('Product 1', 'Description for product 1', 19.99);
INSERT INTO products (name, description, price) VALUES ('Product 2', 'Description for product 2', 29.99);

---- Insert sample data into reviews table
INSERT INTO reviews (rating, comment, user_id, product_id) VALUES (5, 'Great product!', 1, 1);
INSERT INTO reviews (rating, comment, user_id, product_id) VALUES (4, 'Very good, but a bit expensive.', 2, 2);