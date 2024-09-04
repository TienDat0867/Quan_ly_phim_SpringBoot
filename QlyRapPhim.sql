create database QlyRapPhim
go
drop database QlyRapPhim
go
use QlyRapPhim
go
use master
go
select * from taikhoan 
go
select * from nhanvien 
go
select * from khachhang
go
create table taikhoan 
(
	matk int primary key identity(1,1),
	tendn nvarchar(255),
	matkhau nvarchar(255) ,
	ngaytao date ,
	loaitk int
)
go 

insert into taikhoan(tendn,matkhau,ngaytao,loaitk) values
	(N'huongpham','123',N'2024/02/03',1),
	(N'tranngoc1241@gmail.com','123',N'2024/02/03',0),
	(N'long@gmail.com','123',N'2024/02/03',2)
go
create table khachhang 
(
	makh int primary key identity(1,1),
	hoten nvarchar(255) ,
	diachi nvarchar(255) ,
	email nvarchar(255) ,
	sodienthoai int ,
	ngaysinh date ,
	anh nvarchar(255),
	trangthai bit  default 1 ,
	matk int foreign key 
	references taikhoan(matk)
)
go
insert into khachhang(hoten,diachi,email,sodienthoai,ngaysinh,anh,matk) values
(N'Phạm Văn Hưởng',N'77 Lê Nguyên,p6,Q3,Hồ Chí Minh',N'huong@gmail.com',03854472,'2003-02-01',N'hinh-anh-luffy-cute.jpg',1),
(N'Trần Văn Ngọc',N'11 Võ Văn Tần,p6,Dĩ An,Bình Dương',N'ngoc@gmail.com',03285839,'2003-09-01',N'zoro.jfif',2),
(N'Phạm Thị Mai',N'254 Tôn Thất Hiệp,p1,Hoàng Mai,Hà Nội',N'mai@gmail.com',0329643,'2003-11-01',N'nami.jpg',3)
go
create table nhanvien 
(
	manv int primary key identity(1,1),
	hoten nvarchar(255) ,
	email nvarchar(255) ,
	diachi nvarchar(255) , 
	sdt int  ,
	anh nvarchar(255) ,
	ngayvaolam date,
	trangthai bit default 1,
	matk  int unique foreign key 
	references taikhoan(matk),
	chucvu int 
)
go

insert into nhanvien(hoten,email,diachi,sdt,anh,ngayvaolam,trangthai,matk,chucvu) values
(N'Trần văn Ngọc',N'ngoctvps27622@fpt.edu.vn'	,N'thôn 1 xã quãng trị', 0121041,N'hinhAnhNgoc.jpg',N'2024-06-07',1,2,1),
(N'Phạm Văn Hưởng',N'Huong@gmail.com',N'Hà nội', 0331423,NULL,N'2024-01-07',1,1,1),
(N'Võ hoàng long',N'huongpham1913@gmail.com',N'Quãng ngải', 0310011,Null,N'2024-01-07',1,3,2)
go
create table quanly
(
	maquanly int primary key identity(1,1),
	tenquanly nvarchar(255) ,
	email nvarchar(255) ,
	anh nvarchar(255) ,
	matk int foreign key 
	references taikhoan(matk)
)
go
create table phim 
(
	maphim int primary key identity(1,1) ,
	tenphim nvarchar(255),
	ngaysanxuat date,
	hinhanh nvarchar(255),
	quocgia nvarchar(255),
	thoiluong int ,
	mota nvarchar(max),
	href nvarchar(255)
)
go
insert into phim values 
(N'Furiosa: Câu Chuyện Từ Max Điên','2024-05-22','furiosa-sneak-500_1715831976778.jpg',N'Úc',148,N'Furiosa: A Mad Max Saga xảy ra trước những sự kiện của Mad Max: Fury Road, câu chuyện kể về thời trẻ của nữ chiến binh Furiosa khi cô bị tách ra khỏi nơi ẩn náu ở Green Place of Many Mothers và lần đầu tiên buộc phải đối mặt với sự điên rồ của thế giới bên ngoài. Nhưng cô ấy luôn nuôi trong mình một khát vọng “trở về đất mẹ” mãnh liệt.','nVVungjjsfY'),
(N'Haikyu!!: Trận Chiến Bãi Phế Liệu','2024-05-15','haikyuu-the-dumpster-battle-4_1715588036535.jpg',N'Nhật Bản',85,N'Một trong những series manga và anime thể thao về bóng chuyền nổi tiếng nhất mọi thời đại. Cuộc đối đầu bóng chuyền giữa hai đối thủ đầy "duyên nợ" Cao trung Karasuno và THPT Nekoma hứa hẹn sẽ vô cùng kịch tính và không kém phần thú vị. Bạn sẽ theo team Quạ hay team Mèo?','AXAjOCpMTlg'),
(N'Án mạng lầu 4','2024-05-16','an-mang-lau-4-500_1715833965041.jpg',N' Việt Nam',106,N'Một cặp vợ chồng hạnh phúc đang bị mắc kẹt trong những tình huống và thử thách kinh hoàng. Một vụ án mạng nhưng hiện trường lại không có vết máu, tội ác lại càng không. Vậy chuyện gì đã thực sự diễn ra ở lầu 4?  Phim mới Án Mạng Lầu 4 suất chiếu sớm 16.05.2024 (Không áp dụng Movie Voucher), khởi chiếu 17.05.2024 tại các rạp chiếu phim toàn quốc. ','agzckaoLRaY'),
(N'Hành tinh khỉ:Vương quốc mới','2024-05-10','hanh-tinh-khi-500_1714984209746.jpg',N'Mỹ',144,N'Kingdom Of The Planet Of The Apes lấy bối cảnh nhiều đời sau Caesar đại đế, hành tinh này là nơi loài khỉ thống trị, còn loài người dần lui về trong bóng tối. Khi một thủ lĩnh khỉ bạo chúa bắt đầu xây dựng đế chế của riêng mình, buộc thủ lĩnh một tộc khỉ khác phải bước vào hành trình tăm tối để tìm kiếm tự do, quyết định tương lai của loài người và khỉ','Z0EL1PDgPS0'),
(N'Luyện ngải:Cô hồn dã quỷ','2024-05-17','luyen-ngai-500_1715569977281.jpg',N'Thái Lan',103,N'Trong một lần trấn yểm ác linh quỷ quyệt, thầy phù thuỷ Kaew đã chiến thắng. Nhưng ngạ quỷ nhanh chóng thoát khỏi phong ấn, ám lấy thể xác người tình Kaew, khiến anh đứng trước tình thế tiến thoái lưỡng nan.','Oz-MCOD8UNA'),
(N'Tháng 4, ngày em đến','2024-05-17','april-come-she-will-2_1714729128218.jpg',N'Nhật bản',108,N'Tháng 4 chính là thời điểm mở màn cho mùa phim hè 2015 – mùa phim bom tấn với những siêu phẩm giải trí được chờ đợi nhất trong năm. Hãy chuẩn bị tinh thần cho những màn đua xe nghẹt thở, sự tập hợp trở lại của các siêu anh hùng Marvel trong cuộc chiến sống còn, những màn đấu súng dữ dội từ Liam Neeson, một phim kinh dị-hài “made in Việt Nam”… và nhiều hơn thế nữa!','IkPxIfp4VHs'),
(N'Abilgail','2024-05-10','abigail-500_1714116959247.jpg',N'Mỹ',109,N'Một nhóm tội phạm bắt cóc một diễn viên ba lê nhí - con gái của một ông trùm quyền lực trong thế giới ngầm. Chúng trốn đến một biệt thự biệt lập, nhưng không hề hay biết mình đang bị giam cầm cùng một "cô bé" hoàn toàn không bình thường.','PS6eBzYCIkY'),
(N'Panda đại náo lãnh địa sư tử','2024-04-30','panda-500_1712807666563.jpg',N'Đức',88,N'Để giải cứu rồng con Tiểu Long đang bị bắt cóc sang châu Phi, Gấu trúc Bư quyết định ra đi tìm đường cứu bạn. Trên hành trình của mình, Bư đã khám phá ra một thế giới hoàn toàn xa lạ và phải đối mặt với những con hà mã đáng sợ, những con linh cẩu khôn ngoan và những con khỉ đột chiêu trò. Dựa vào trí thông minh của mình, Bư đã tìm đường băng xuyên châu Phi trước khi giải cứu Tiểu Long và cứu ngôi nhà trong rừng rậm của những người bạn mới trước âm mưu tàn ác của sư tử Malume.','iwKJ-qxo-t8'),
(N'Lật mặt 7','2024-04-24','lm7-500_1714101585009.jpg',N'Việt Nam',138,N'Qua những lát cắt đan xen, ẩn chứa nhiều nụ cười và cả nước mắt, "Lật Mặt 7: Một Điều Ước" là câu chuyện cảm động về đại gia đình bà Hai 73 tuổi - người mẹ đơn thân tự mình nuôi 5 người con khôn lớn. Khi trưởng thành, mỗi người đều có cuộc sống và gia đình riêng. Bất chợt, biến cố ập đến, những góc khuất dần được hé lộ, những nỗi niềm, lo lắng, trĩu nặng ẩn sâu trong trái tim người mẹ. Trách nhiệm thuộc về ai?','d1ZHdosjNX8'),
(N'Vây hãm:kẻ trừng phạt','2024-04-24','roundup-500_1714102279125.jpg',N'Hàn Quốc',109,N'Siêu cớm Ma Seok-do tái xuất để đối đầu với những tội phạm tinh vi trong giới công nghệ. Nắm đấm trứ danh liệu có phát huy được sức mạnh trước liên minh tội phạm của thiên tài công nghệ và ông trùm nhà cái lớn nhất châu Á?','XTI1j_bgREY')
go

create table listfavourite
(
	maphim int,
	makh int,
	primary key(maphim, makh),
	foreign key (maphim) references phim(maphim),
	foreign key (makh) references khachhang(makh)
)	
go
create table loaiphim
(
	maloaiphim nvarchar(255) primary key  ,
	tenloaiphim nvarchar(255) 
)
go

insert into loaiphim values
(N'TL',N'Tâm Lý'),
(N'GG',N'Giật Gân'),
(N'GT',N'Giả Tưởng'),
(N'HD',N'Hành Động'),
(N'TC',N'Tình Cảm'),
(N'KD',N'Kinh Dị'),
(N'HH',N'Hài Hước')
go

create table phim_loaiphim
(
	maphim int, 
	maloaiphim nvarchar(255) ,
	primary key(maphim, maloaiphim),
	foreign key (maphim) references phim(maphim),
	foreign key(maloaiphim) references loaiphim(maloaiphim)
)
go

insert into phim_loaiphim(maphim,maloaiphim) values
(1,'HH'),
(1,'HD'),
(3,'KD'),
(3,'TL'),
(4,'HD'),
(4,'GT'),
(5,'KD'),
(5,'GG'),
(6,'TL'),
(6,'TC'),
(7,'GT'),
(7,'HD'),
(8,'HH'),
(8,'TL'),
(9,'TL'),
(9,'TC'),
(9,'HH'),
(10,'HD'),
(2,'GG')
go
create table daodien
(
	madaodien nvarchar(255) primary key ,
	tendaodien nvarchar(255) 
)
go

insert into daodien values
(N'Shin',N'Shin-Ei Animation'),
(N'George',N'George Miller'),
(N'Susumu',N'Susumu Mitsunaka'),
(N'Wes',N'Wes Ball'),
(N'Mate',N'Mate Yimsomboon '),
(N'Tomokazu',N'Tomokazu Yamada '),
(N'Matt',N'Matt Bettinelli-Olpin '),
(N'Tyler',N'Tyler Gillett '),
(N'KARSTEN',N'KARSTEN KIILERICH '),
(N'LH',N'Ly Hai'),
(N'Heo',N' Heo Myeong Haeng')
go

create table phim_daodien
(
	maphim int,
	madaodien nvarchar(255) ,
	primary key(maphim,madaodien) ,
	foreign key(maphim) references phim(maphim),
	foreign key(madaodien) references daodien(madaodien)
)
go 

 insert into phim_daodien(maphim,madaodien) values 
(1,N'Shin'),				
(2,N'George'),
(3,N'Susumu'),
(4,N'Wes'),
(5,N'Mate'),
(6,N'Tomokazu'),
(7,N'Matt'),
(7,N'Tyler'),
(8,N'KARSTEN'),
(9,N'LH'),
(10,N'Heo')
 go


create table phongchieu
(
	maphongchieu int primary key identity(1,1),
	tenphongchieu nvarchar(255),
	soghetoida int
)
go


insert into phongchieu(tenphongchieu,soghetoida) values
(N'Phong 1',60),
(N'Phong 2',80),
(N'Phong 3',50)
go

create table ghe
(
	maghe int primary key identity(1,1) ,
	soghe nvarchar(255),
	dongia int,
	loaighe int,
	trangthai bit default 1,
	maphongchieu int foreign key
	references phongchieu(maphongchieu) 
)
select * from ghe 
go

 -- Phòng Chiếu 1
 -- Hàng A
declare @i int=1;
declare @maphongchieu int =1;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'A' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go

 -- Hàng B
declare @i int=1;
declare @maphongchieu int =1;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'B' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go
 -- Hàng C
declare @i int=1;
declare @maphongchieu int =1;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'C' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go
 -- Hàng D
declare @i int=1;
declare @maphongchieu int =1;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'D' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go

 -- Hàng E
declare @i int=1;
declare @maphongchieu int =1;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'E' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go
-- Hàng V
declare @i int=1;
declare @maphongchieu int =1;
declare @loaighe int=2;
while @i<=10
begin 
insert into ghe (maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,100000,'V'+ CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go

 -- Phòng Chiếu 2
 -- Hàng A
declare @i int=1;
declare @maphongchieu int =2;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'A' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go

 -- Hàng B
declare @i int=1;
declare @maphongchieu int =2;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'B' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go
 -- Hàng C
declare @i int=1;
declare @maphongchieu int =2;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'C' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go
 -- Hàng D
declare @i int=1;
declare @maphongchieu int =2;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'D' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go

 -- Hàng D
declare @i int=1;
declare @maphongchieu int =2;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'H' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go

 -- Hàng E
declare @i int=1;
declare @maphongchieu int =2;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'E' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go

-- Hàng F
declare @i int=1;
declare @maphongchieu int =2;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'F' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go

-- Hàng V
declare @i int=1;
declare @maphongchieu int =2;
declare @loaighe int=2;
while @i<=10
begin 
insert into ghe (maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,100000,'V'+ CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go

 -- Phòng Chiếu 3
 -- Hàng A
declare @i int=1;
declare @maphongchieu int =3;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'A' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go

 -- Hàng B
declare @i int=1;
declare @maphongchieu int =3;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'B' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go
 -- Hàng C
declare @i int=1;
declare @maphongchieu int =3;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'C' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go
 -- Hàng D
declare @i int=1;
declare @maphongchieu int =3;
declare @loaighe int=1;
while @i<=10
begin 
insert into ghe(maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,80000, 'D' +CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go
-- Hàng V
declare @i int=1;
declare @maphongchieu int =3;
declare @loaighe int=2;
while @i<=10
begin 
insert into ghe (maphongchieu,dongia,soghe,loaighe) values
(@maphongchieu,100000,'V'+ CAST(@i as nvarchar(255)),@loaighe);
set @i= @i +1;
end;
go
select * from ghe 
go

create table lichchieu
(
	malichchieu int primary key identity(1,1) ,
	maphongchieu int foreign key 
	references phongchieu(maphongchieu) ,
	maphim int foreign key 
	references phim(maphim),
	ngaychieu date,
	giochieu nvarchar(255)
)
go
select * from lichchieu go

insert into lichchieu(maphongchieu,maphim,ngaychieu,giochieu) values
(1,1,N'2024-06-01','09:30'),
(1,2,N'2024-06-01 ','11:30'),
(1,3,N'2024-06-01 ','14:30'),
(2,1,N'2024-05-29 ','09:30'),
(2,1,N'2024-05-29 ','09:30'),
(2,4,N'2024-05-29 ','14:00'),
(2,5,N'2024-05-30 ','18:00'),
(2,6,N'2024-05-30 ','21:00'),
(3,7,N'2024-06-02 ','09:30'),
(3,8,N'2024-06-02 ','12:00'),
(3,8,N'2024-06-02 ','17:00'),
(3,8,N'2024-06-02 ','22:00'),
(3,8,N'2024-06-03 ','10:00'),
(3,8,N'2024-06-03 ','18:00'),
(2,1,N'2024-05-29 ','19:30'),
(1,1,N'2024-05-29 ','19:30')
go



select * from lichchieu
go

SELECT l1_0.malichchieu, p2_0.tenphim, p1_0.tenphongchieu, l1_0.ngaychieu, l1_0.giochieu, COUNT_BIG(g1_0.maghe)
FROM lichchieu l1_0
JOIN phongchieu p1_0 ON p1_0.maphongchieu = l1_0.maphongchieu
JOIN ghe g1_0 ON p1_0.maphongchieu = g1_0.maphongchieu
JOIN phim p2_0 ON p2_0.maphim = l1_0.maphim
WHERE p2_0.maphim = 3 AND l1_0.ngaychieu = '2024-06-01' AND l1_0.giochieu = '14:30'
GROUP BY l1_0.malichchieu, p2_0.tenphim, p1_0.tenphongchieu, l1_0.ngaychieu, l1_0.giochieu;
go


insert into lichchieu(maphongchieu,maphim,ngaychieu,giochieu) values
(2,1,N'2024-06-06 ','18:00:00')
go
select phim.tenphim,phongchieu.tenphongchieu,lichchieu.thoigianchieu,count(ghe.maghe) as soghe
from lichchieu inner join phim on lichchieu.maphim=phim.maphim 
inner join phongchieu on lichchieu.maphongchieu = phongchieu.maphongchieu
inner join ghe on ghe.maphongchieu=phongchieu.maphongchieu
where phongchieu.maphongchieu =2 and phim.maphim =1 and lichchieu.thoigianchieu= '2024-06-06 18:00:00'
group by phim.tenphim, phongchieu.tenphongchieu,lichchieu.thoigianchieu
go
select phim.tenphim,phongchieu.tenphongchieu,lichchieu.thoigianchieu,count(ghe.maghe) as soghe
from lichchieu inner join phim on lichchieu.maphim=phim.maphim 
inner join phongchieu on lichchieu.maphongchieu = phongchieu.maphongchieu
inner join ghe on ghe.maphongchieu=phongchieu.maphongchieu
where phim.maphim =1 
group by phim.tenphim, phongchieu.tenphongchieu,lichchieu.thoigianchieu
go
create table ve
(
	mave int primary key identity(1,1),
	ngaydatve date,
	tongtien int ,
	trangthai bit,
	tongsoghe int,
	makh int,
	manv int foreign key 
	references nhanvien(manv),
	malichchieu int foreign key
	references lichchieu(malichchieu)
)
go

create table vechitiet
(
	mavechitiet int primary key identity(1,1),
	dongia int,
	soluong int,
	tongtien int,
	mave int foreign key 
	references ve(mave),
	maphim int foreign key
	references phim(maphim),
	maghe int foreign key 
	references ghe(maghe)
)
go
select * from ve 
go
select * from vechitiet 
go


