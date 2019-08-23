USE storefrontapplicationdb;

#2.1 Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT p.id, p.name, COUNT(*) AS category_count
FROM product p INNER JOIN sub_category sc ON p.id = sc.productId
GROUP BY sc.productId
HAVING category_count > 1;

#2.2 Display Count of products as per price range.
SELECT pr.price_range, COUNT(*) AS product_count
FROM(SELECT CASE 
	WHEN price>0 AND price<=100 THEN '0-100'
    WHEN price>100 AND price<=500 THEN '100-500'
    ELSE 'ABOVE 500'
    END AS price_range
    FROM product) pr
GROUP BY pr.price_range;

#2.3 Display the Categories along with number of products under each category.
SELECT c.id,c.name,COUNT(*) AS product_count
FROM category c INNER JOIN sub_category sc ON c.id=sc.categoryId
GROUP BY sc.categoryId;

#3.1 Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT u.id, u.name, COUNT(*) AS num_of_order
FROM user u INNER JOIN orders o ON u.id = o.userId
WHERE DATEDIFF(CURDATE(), o.order_placing_date)<=30
GROUP BY u.id;

#3.2 Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT u.id, u.name, SUM(p.price * op.order_quantity) AS generated_revenue
FROM User u INNER JOIN Orders o ON u.id=o.userId
     INNER JOIN order_product op ON o.orderId=op.orderId
     INNER JOIN Product p ON op.productId=p.id
WHERE DATEDIFF(CURDATE(),o.order_placing_date)<=30 AND op.orderStatus NOT IN('cancelled')
GROUP BY u.id
ORDER BY generated_revenue DESC
LIMIT 10;

#3.3 Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT p.id, p.name, SUM(op.order_quantity) AS order_product_quantity
FROM Product p INNER JOIN order_product op ON p.id=op.productId 
     INNER JOIN orders o ON op.orderId = o.orderId
WHERE DATEDIFF(CURDATE(),o.order_placing_date)<=60
GROUP BY p.id
ORDER BY order_product_quantity DESC
LIMIT 20;

#3.4 Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT MONTH(o.order_placing_date) AS month,SUM(p.price * op.order_quantity) AS sales_revenue
FROM Orders o INNER JOIN order_product op ON o.orderId=op.orderId
     INNER JOIN product p ON op.productId = p.id
WHERE TIMESTAMPDIFF(MONTH, o.order_placing_date, CURDATE())<=6 AND op.orderStatus NOT IN('cancelled')
GROUP BY month;

#3.5 Mark the products as Inactive which are not ordered in last 90 days.
UPDATE product p
SET is_active = false
WHERE p.id NOT IN(SELECT p.id
                FROM Orders o LEFT JOIN order_product op ON op.orderId = o.orderId
                WHERE p.id = op.productId AND DATEDIFF(CURDATE(),o.order_placing_date)<=90);
SELECT * FROM product;

#3.6 Given a category search keyword, display all the Products present in this category/categories. 
SELECT p.id, p.name AS product_name, c.name AS category_title
FROM Product p INNER JOIN sub_category sc ON p.id=sc.productId 
     INNER JOIN category c ON sc.categoryId=c.id
WHERE c.name IN('electronics','stationary');

#3.7 Display top 10 Items which were cancelled most.
SELECT p.id,p.name,COUNT(*) AS cancelled_count
FROM product p INNER JOIN order_product op ON p.id=op.productId
WHERE op.orderStatus IN('canceled')
GROUP BY p.id
ORDER BY cancelled_count DESC
LIMIT 100;

#4 Consider a form where providing a Zip Code populates associated City and State.
CREATE TABLE ziscode(
pincode INT NOT NULL,
city VARCHAR(100) NOT NULL,
state VARCHAR(100) NOT NULL,
PRIMARY KEY(pincode)
);

INSERT INTO Ziscode(pincode, city, state)
values(302012, 'jaipur', 'rajasthan'),
	  (302022, 'jaipur','rajasthan'),
      (302212, 'churu', 'rajasthan'),
      (202012,'kanpur', 'up'),
      (602012, 'jodhpur','rajasthan'),
      (206012, 'lucknow', 'up'),
      (201812, 'chittorgarh', 'rajasthan'),
      (202245, 'jaipur', 'rajasthan'),
      (805012, 'kolkata',  'west bengal');
  
SELECT pincode,city,state
FROM Ziscode
ORDER BY state,city;

#5.1 Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status)
# with latest ordered items should be displayed first for last 60 days.
CREATE VIEW Order_Information AS 
	SELECT o.orderId, op.productId, p.name AS product_name, op.order_quantity, p.price*op.order_quantity AS total_price, u.name AS user_name, u.email, o.order_placing_date, op.orderStatus
	FROM Orders o 
    INNER JOIN order_product op ON o.orderId = op.orderId
	INNER JOIN Product p ON op.productId=p.id
	INNER JOIN User u ON o.userId=u.id
		WHERE DATEDIFF(CURDATE(),o.order_placing_date)<=60
		ORDER BY o.order_placing_date DESC;
                                 
SELECT * FROM Order_Information;


#5.2 Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT orderId, productId, product_name, order_quantity, total_price, user_name, email, order_placing_date, orderStatus
FROM Order_Information
WHERE orderStatus IN('shipped');

#5.3 Use the above view to display the top 5 most selling products.
SELECT productId, product_name,SUM(order_quantity) AS total_ordered_quantity
FROM Order_Information
WHERE orderStatus NOT IN('cancelled')
GROUP BY productId
ORDER BY total_ordered_quantity DESC
LIMIT 5;