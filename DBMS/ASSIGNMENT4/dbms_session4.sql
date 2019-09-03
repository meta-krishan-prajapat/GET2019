USE StoreFrontdb;

#1.1 Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
DELIMITER $$
CREATE FUNCTION get_number_of_orders(in_month INT, in_year INT)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE num_of_orders INT;
    
    SELECT COUNT(*) INTO num_of_orders
    FROM Orders
    WHERE MONTH(order_placing_date) IN(in_month) AND YEAR(order_placing_date) IN(in_year);
    
    RETURN(num_of_orders);
END $$

SELECT get_number_of_orders(6,2019);

#1.2 Create a function to return month in a year having maximum orders. Year will be input parameter.
DELIMITER $$
CREATE FUNCTION get_month_having_maximum_orders(input_year INT) RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE month_having_maximum_orders INT;
    
    SELECT MONTH(order_placing_date) INTO month_having_maximum_orders
    FROM Orders
    WHERE YEAR(order_placing_date) IN(input_year)
    GROUP BY MONTH(order_placing_date)
    ORDER BY COUNT(*) DESC
    LIMIT 1;
    
    RETURN(month_having_maximum_orders);
END $$

SELECT get_month_having_maximum_orders(2019);

#2.1 Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.
DELIMITER $$
CREATE PROCEDURE get_average_sale(IN input_month INT,IN input_year INT)
BEGIN
    SELECT op.productId,
           p.name, 
           MONTH(o.order_placing_date), 
           SUM(op.order_quantity) AS average_sale
    FROM Orders o INNER JOIN order_product op ON o.orderId=op.orderId
         INNER JOIN Product p ON op.productId=p.id
    WHERE MONTH(o.order_placing_date) IN (input_month)
          AND YEAR(o.order_placing_date) IN (input_year)
    GROUP BY op.productId;
END $$

CALL get_average_sale(8,2019);

#2.2 Create a stored procedure to retrieve table having order detail with status for a given period. 
# Start date and end date will be input parameter. Put validation on input dates like start date is less than end date.
# If start date is greater than end date take first date of month as start date.
DELIMITER $$
CREATE PROCEDURE get_order_detail(IN start_date DATE,IN end_date DATE)
BEGIN
    IF start_date>end_date THEN 
        SET start_date=end_date-Interval day(end_date) DAY;
    END IF;
    SELECT o.orderId,
           o.userId,
           u.name AS user_name,
           op.productId,
           p.name AS product_name, 
           o.order_placing_date,
           p.price*op.order_quantity AS total_price,
           op.orderStatus
    FROM Orders o INNER JOIN User u ON o.userId=u.id
         INNER JOIN order_product op ON o.orderId=op.orderId
         INNER JOIN Product p ON op.productId=p.id
    WHERE o.order_placing_date>=start_date 
          AND o.order_placing_date<=end_date;
END $$

CALL get_order_detail('2019-01-01',CURDATE());

#3 Identify the columns require indexing in order, product, category tables and create indexes.
#Index on Product Table
CREATE INDEX added_on_date_index ON product(added_on_date);

#Index on Category Table
CREATE INDEX parent_category_index ON category(root);

#Index on Orders Table
CREATE INDEX order_placing_date_index ON orders(order_placing_date);

#Index on Order_Product Table
CREATE INDEX order_id_index ON order_product(orderId);