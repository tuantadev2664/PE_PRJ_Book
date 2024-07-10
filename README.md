-- Create the database
CREATE DATABASE PE_Books_DE180316;
GO

-- Use the Books_YourID database
USE PE_Books_DE180316;
GO

-- Create the Books table
CREATE TABLE Books (
    id INT PRIMARY KEY IDENTITY(1,1),
    title NVARCHAR(255) NOT NULL,
    author NVARCHAR(255) NOT NULL,
    published_year varchar(4) NOT NULL,
    genre NVARCHAR(100)
);

-- Insert sample data into the Books table
INSERT INTO Books (title, author, published_year, genre)
VALUES
    ('Book 1', 'Author 1', 2020, 'Fiction'),
    ('Book 2', 'Author 2', 2018, 'Mystery');
GO

-- Create the Members table
CREATE TABLE Members (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) NOT NULL,
    join_date varchar(10) NOT NULL
);

-- Insert sample data into the Members table
INSERT INTO Members (name, email, join_date)
VALUES
    ('John Doe', 'johndoe@example.com', '2020-01-01'),
    ('Jane Smith', 'janesmith@example.com', '2021-03-15');
GO
