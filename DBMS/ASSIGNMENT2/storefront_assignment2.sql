USE storefrontdb;
#1. Insert values in respective table.
INSERT INTO product(id, name, price, quantity, is_active, product_image, added_on_date, description)
values(1, 'earphones', 1500.0, 5, true, 'C:\Users\Admin\MysqlWorkspace\earphones.jpg', '2018-01-01', 'jbl earphones'),
      (2, 'headphones', 1600.0, 5, true, 'C:\Users\Admin\MysqlWorkspace\headphones.jpg', '2019-01-23', 'bose headphones'),
      (3, 'heels', 700.0, 10, true, 'C:\Users\Admin\MysqlWorkspace\heels.jpg', '2019-05-01', 'black heels'),
      (4, 'shoes', 1000.0, 4, true, 'C:\Users\Admin\MysqlWorkspace\shoes.jpg', '2019-07-07', 'adidas shoes'),
      (5, 'mobile cover', 1200.0, 5, true, 'C:\Users\Admin\MysqlWorkspace\cover.jpg', '2018-11-20', 'mi anti shock mobile cover'),
      (6, 'watch', 3000.0, 0, false, 'C:\Users\Admin\MysqlWorkspace\watch.jpg', '2018-07-29', 'fossils watch'),
      (7, 'toy laptop', 1200.0, 5, true, 'C:\Users\Admin\MysqlWorkspace\laptop.jpg', '2019-01-30', 'kids toy laptop'),
      (8, 'toy cycle', 1400.0, 5, true, 'C:\Users\Admin\MysqlWorkspace\cycle.jpg', '2019-07-01', 'kids 4 wheels cycle'),
      (9, 'tshirt', 500.0, 10, true, 'C:\Users\Admin\MysqlWorkspace\tshirt.jpg', '2019-01-21', 'roadster tshirt'),
      (10, 'suit', 600.0, 5, true, 'C:\Users\Admin\MysqlWorkspace\suit.jpg', '2019-05-01', 'manyavar suit'),
      (11, 'bags', 1000.0, 5, true, 'C:\Users\Admin\MysqlWorkspace\bags.jpg', '2018-12-05', 'american tourister'),
      (12, 'notpads', 50.0, 10, true, 'C:\Users\Admin\MysqlWorkspace\notepad.jpg', '2018-12-01', 'shree notepads'),
      (13, 'pens', 10.0, 20, true, 'C:\Users\Admin\MysqlWorkspace\pens.jpg', '2019-08-01', 'use and throw'),
      (14, 'marker', 20.0, 0, false, 'C:\Users\Admin\MysqlWorkspace\marker.jpg', '2018-12-01', 'red glass marker')
	;

INSERT INTO category(id, name, root)
values(1, 'clothing', null),
      (2, 'stationary', null),
      (3, 'electronics', null),
      (4, 'footwears', null),
      (5, 'clothing men', 1),
      (6, 'clothing women',1),
      (7, 'footwear men', 4),
      (8, 'footwear women', 4),
      (9, 'accessories', null),
      (10, 'kids toys', null)
      ;

INSERT INTO sub_category(productId, categoryId)
values(1,3),
      (2,3),
      (3,4),
      (4,4),
      (5,4),
      (6,9),
      (7,10),
      (8,10),
      (9,5),
      (10,6),
      (11,2),
      (12,2),
      (13,2),
      (14,2)
      ;

INSERT INTO user(id,name,password,email,is_admin)
values(1,'krishan', 'kp123', 'kp123@gmail.com', false),
      (2, 'chandra', 'c123', 'chandra@gmail.com', false),
      (3, 'nisha', 'n123', 'nisha@gmail.com', false),
      (4, 'shweta', 'shweta', 'shweta@gmail.com', false),
      (5, 'jyoti', 'y123', 'jyoti@gmail.com', false),
      (6, 'kp', 'k123', 'kp@gmail.com', false),
      (7, 'naman', 'n123', 'naman@gmail.com', false),
      (8, 'vinod', 'v123', 'vinod@gmail.com', false),
      (9, 'neha', 'n123', 'neha@gmail.com', false),
      (10, 'soni', 's123', 'soni@gmail.com', false)
      ;

INSERT INTO address(addressId, userId, housenum, street, city, state, country, pincode)
values(1, 1, '117', 'ranjeet', 'jaipur', 'rajasthan', 'INDIA', 302012),
      (2, 1, '117', 'gopal nagar', 'jaipur', 'rajasthan', 'INDIA', 302012),
      (3, 2, '117', 'ranjeet', 'jaipur', 'rajasthan', 'INDIA', 302012),
      (4, 3, 'b8', 'vki', 'jaipur', 'rajasthan', 'INDIA', 302022),
      (5, 4, '120', 'barra', 'kanpur', 'up', 'INDIA', 202012),
      (6, 6, '220', 'churu', 'churu', 'rajasthan', 'INDIA', 302212),
      (7, 8, '420', 'narayn', 'jodhpur', 'rajasthan', 'INDIA', 302012),
      (8, 10, '850', 'shiva colony', 'lucknow', 'up', 'INDIA', 206012)
;

INSERT INTO address(addressId, userId, housenum, street, city, state, country, pincode)
values(9, 5, '120', 'chittor', 'chittorgarh', 'rajasthan', 'INDIA', 201812),
      (10, 7, 'a-6', 'tonk road', 'jaipur', 'rajasthan', 'INDIA', 202245),
      (11, 9, '210', 'premjeet', 'kolkata', 'west bengal', 'INDIA', 805012)
      ;

INSERT INTO orders( orderId, userId, order_placing_date, bill)
values(102, 1, '2018-08-12', 3000.0),
      (103, 10, '2019-05-05', 5600.0),
      (185, 7, '2019-06-04', 1000.0),
      (210, 2, '2019-04-13', 2000.0),
      (222, 5, '2019-06-12', 2600.0),
      (243, 6, '2019-06-14', 1100.0),
      (253, 3, CURDATE(), 700.0),
      (295, 5, CURDATE(), 10.0),
      (310, 8, CURDATE(), 1200.0),
      (322, 9, CURDATE(), 1200.0),
      (324, 1, CURDATE(), 1600.0),
      (325, 1, CURDATE(), 1200.0),
      (355, 3, CURDATE(), 1200.0),
      (365, 6, CURDATE(), 1200.0),
      (400, 7, CURDATE(), 1400.0),
      (450, 8, CURDATE(), 100.0)
      ;
      
INSERT INTO order_product(orderId, productId, shipping_add_id, order_quantity, orderStatus)
values(102, 1, 1, 1, 'delivered'),
      (102, 3, 1, 1, 'delivered'),
      (102, 12, 1, 6, 'delivered'),
      (103, 2, 8, 1, 'canceled'),
      (103, 11, 8, 1, 'delivered'),
      (185, 11, 10, 1, 'delivered'),
      (210, 4, 3, 1, 'canceled'),
      (210, 9, 3, 2, 'delivered'),
      (222, 7, 9, 1, 'canceled'),
      (222, 8, 9, 1, 'canceled'),
      (243, 10, 6, 1, 'shipped'),
      (243, 9, 6, 1, 'shipped'),
      (253, 3, 4, 1, 'shipped'),
      (295, 13, 9, 1, 'shipped'),
      (310, 10, 7, 2, 'order placed'),
      (322, 5, 11, 1, 'order placed'),
      (324, 2, 2, 1, 'order placed'),
      (325, 5, 2, 1, 'order placed'),
      (355, 5, 4, 1, 'order placed'),
      (365, 7, 6, 1, 'shipped'),
      (400, 8, 10, 1, 'shipped'),
      (450, 12, 7, 2, 'shipped')
      ;
      
#2. Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
SELECT p.id, p.name, p.price, c.name
FROM product p, sub_category sc, category c
WHERE p.is_active = true AND p.id = sc.productId AND sc.categoryId = c.id
ORDER BY p.added_on_date DESC;

#3.Display the list of products which do not have any images.
SELECT p.product_image
FROM product p
WHERE p.id = null;

#4.Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. 
#(If Category is top category then Parent Category Title column should display “Top Category” as value.)
SELECT c1.id, c1.name,c2.name,
	IFNULL(c2.name, 'Top Category') as parent
FROM category c1 LEFT JOIN category c2 ON c1.root = c2.id
ORDER BY c1.root, c1.name;

#5.Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
SELECT c1.id, c1.name, c1.root
FROM category c1
WHERE c1.id NOT IN (SELECT c2.root FROM category c2 WHERE c2.root IS NOT NULL)
;

#6.Display Product Title, Price & Description which falls into particular category Title
SELECT p.name, p.price, p.description
FROM product p, category c, sub_category sc
WHERE p.id = sc.productId AND c.id = sc.categoryId ;

#7.Display the list of Products whose Quantity on hand (Inventory) is under 50.
SELECT p.name, p.quantity
FROM product p
WHERE p.quantity < 50;

#8.Increase the Inventory of all the products by 100.
UPDATE product
SET quantity = quantity + 100
WHERE id IS NOT NULL;
