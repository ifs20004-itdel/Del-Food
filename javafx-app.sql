CREATE TABLE account (
	idUser int Not null primary key,
    username VARCHAR(50) NULL,
	email VARCHAR (50) NULL,
	password VARCHAR(50) NULL);

CREATE TABLE product (
	idproduct int NOT NULL PRIMARY KEY,
    Nama_Produk VARCHAR(50) NULL,
    Harga int NULL,
    Deskripsi VARCHAR(200) NULL
);

insert into `javafx-app`.`account` (idUser, username, email, password)
		values	(1,'samuel1204','samuelsibuea82@gmail.com', 'AAAAAA'),
				(2 ,'valen1234Shn','valentinasiahaan9@gmail.com', 'BBBBBB'),
				(3 ,'Siallaganchnt','cheilintsiallagan@gmail.com', 'CCCCCC'),
				(4 ,'mic_ifhonce','michaelnapitupulu345@gmail.com', 'DDDDDD'),
				(5,'lsirait12','lamboysirait87@gmail.com', 'EEEEEE'),
				(6,'simbolon23','reinhardsimbolon@gmail.com', 'FFFFFF'),
				(7,'Cla2468','claudina2468@gmail.com', 'GGGGGG'),
				(8,'Ethapl12','margarethapulen@gmail.com', 'HHHHHH'),
				(9,'1234abcd','aldianfelix@gmail.com', 'IIIIII'),
				(10,'Hotsimbolon','hottuasimbolon@gmail.com', 'JJJJJJ'),
				(11,'theSantos34','santoso@gmail.com', 'KKKKKK'),
				(12,'nn7678ac','neny7678@gmail.com', 'LLLLLL'),
				(13,'Starla86','starla86@gmail.com', 'MMMMMM');
                
insert into `javafx-app`.`product`
	values	(1,'Teh Manis', 5000,null),
			(2, 'Teh Hijau', 5000,null),
            (3, 'Lemon Tea', 10000,null),
            (4, 'Susu Milo', 8000,null),
            (5,'Pop Ice', 5000,null),
			(6,'Mie Goreng',20000,null),
            (7,'Mie Kuah', 25000, null),
            (8,'Nasi Goreng', 20000, null),
            (9, 'Ifumie Goreng', 250000, null),
            (10, 'Chicken Pop', 18000, null);
SELECT * FROM `javafx-app`.account;
SELECT * FROM `javafx-app`.product;

-- Query dalam LoginController --
SELECT COUNT(1) FROM `javafx-app`.account WHERE (email = '' AND password = 'AAAAAA') OR (username = 'samuel1204' AND password = 'AAAAAA');
-- TRUNCATE `javafx-app`.ACCOUNT;
