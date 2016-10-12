-- BOOK
select  * from book;
select * from author;


insert into book values(10,'토지10',sysdate,1,'대여가능');

update  book set title = '', state = '대여가능' where no = 12;
