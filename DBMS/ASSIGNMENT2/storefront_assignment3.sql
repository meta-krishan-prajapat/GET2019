USE storefrontdb;

#1. Display Recent 50 Orders placed (Id, Order Date, Order Total).
SELECT orderId, order_placing_date, bill
FROM orders
ORDER BY order_placing_date DESC
LIMIT 50;

#2. Display 10 most expensive Orders.
SELECT orderId, order_placing_date, bill
FROM orders
ORDER BY bill DESC
LIMIT 10;

#3. Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
SELECT o.orderId, o.order_placing_date, o.bill, op.orderStatus
FROM orders o, order_product op
WHERE o.orderId = op.orderId AND op.orderStatus = 'awaiting shipped';

#4.Display list of shoppers which have not ordered anything since last month.
SELECT u.id, u.name, u.email
FROM user u
WHERE u.id NOT IN(SELECT o.userId FROM orders o WHERE TIMESTAMPDIFF(MONTH, o.order_placing_date, CURDATE())<=1);

#5.Display list of shopper along with orders placed by them in last 15 days. 
SELECT u.id, u.name, u.email, o.orderId, o.order_placing_date
FROM user u, orders o
WHERE u.id = o.userId AND DATEDIFF(CURDATE(), o.order_placing_date)<=15;
