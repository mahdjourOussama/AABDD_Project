/*--creating database--*/
create table Département (
    Code_dep int not null , 
    Intitule_dep varchar (50) not null, 
    Nom_chef varchar (50) not null,
    Prenom_chef varchar (50) not null,
    PRIMARY KEY (Code_dep));
create table EMPLOYE (
    Code_emp int not null,
    Nom_emp varchar(50) not null,
    Prenom_emp varchar(50) not null,
    Grade_emp varchar(50) not null,
    Fonction varchar(50) not null,
    Code_dep int not null,
    PRIMARY KEY (Code_emp),
    FOREIGN key (Code_dep)REFERENCES D�partement(Code_dep) );
create table CATEGORIE (
    num_cat int not null ,
    categorie varchar (50) not null,
    PRIMARY KEY (num_cat));
create table Produit ( 
    Code_PRO int not null , 
    Designation varchar(100) not null , 
    Qte_stock int not null, 
    Date_stock date not null,
    seuil int ,
    type_pro varchar(50) not null,
    num_cat int not null,
    PRIMARY KEY (Code_PRO),
    FOREIGN KEY (num_cat) REFERENCES CATEGoRIE(num_cat));
create table FOURNISSEUR (
    Code_fournisseur int not null , 
    Nom_fournisseur varchar(50) not null , 
    Num_compte int not null ,
    Num_Tel int not null,
    Primary Key (Code_Fournisseur));
create table Bon_SORTIE (
    Num_bso int not null , 
    Date_sor date not null,
    Code_emp int not null,
    Primary key (Num_bso),
    Foreign Key (Code_emp) REFERENCES EMPLOYE (Code_emp) ON DELETE CASCADE);
Create table SE_REFERE ( 
    Num_bso int not null, 
    Code_pro int not null ,
    Qte_sortie int not null, 
    Primary key (Num_bso,Code_pro),
    Foreign key (Num_bso) REFERENCES Bon_Sortie(Num_Bso) ON DELETE CASCADE,
    Foreign key (Code_Pro) REFERENCES Produit(Code_pro) ON DELETE CASCADE); 
create table Bon_AFFECTATION (
    Num_baf int not null, 
    Date_aff date not null, 
    Code_emp int not null,
    Primary key (Num_baf),
    FOREIGN KEY (Code_emp) REFERENCES EMPLOYe(Code_emp) ON delete cascade );
Create table CONCERNER (
    Num_baf int not null ,
    Code_PRO int not null, 
    Qte_aff int not null,
    Primary key (Num_baf,Code_pro),
    Foreign key (Num_baf) REFERENCES Bon_AFFECTATION(Num_baf) ON DELETE CASCADE,
    Foreign key (Code_Pro) REFERENCES Produit(Code_pro) ON DELETE CASCADE);
Create table COMMANDE (
    Num_bco int not null,
    Date_com date not null , 
    Code_fournisseur int not null,
    Primary Key (Num_bco),
    FOREIGN key (Code_fournisseur) REFERENCES fournisseur(code_fournisseur)on delete cascade);
create table CONTENIR ( 
    Num_bco int not null ,
    Code_PRO int not null , 
    Qte_cde int not null,
    Primary key (Num_bco,Code_pro),
    Foreign key (Num_bco) REFERENCES COMMANDE(Num_bco) ON DELETE CASCADE,
    Foreign key (Code_Pro) REFERENCES Produit(Code_pro) ON DELETE CASCADE);
create table Bon_LIVRAISON (
    Num_bliv int not null , 
    Date_liv date not null,
    quantité int not null,
    PRIMARY KEY (Num_bliv));
create table RENFERMER (
    Num_bliv int not null,
    Code_PRO int not null,
    Qte_liv int not null,
    Primary key (Num_bliv,Code_pro),
    Foreign key (Num_bliv) REFERENCES Bon_livraison(Num_bliv) ON DELETE CASCADE,
    Foreign key (Code_Pro) REFERENCES Produit(Code_pro) ON DELETE CASCADE);
create table accounts (
    id_user int not null,
    username  varchar(50) not null,
    password varchar(100) not null,
    id_prev int not null,
    PRIMARY KEY (id_user),
    Foreign key (id_user) REFERENCES employe(code_emp) ON DELETE CASCADE,
    Foreign key (id_prev) REFERENCES prevliage(id_pre) ON DELETE CASCADE);
create table prevliage(
    id_pre int not null,
    pre_name varchar(20)not null,
    profile varchar(20) not null,
    PRIMARY KEY (id_pre));
/*--creating profiles and users in  database--*/
create user user1 identified by user1;
create user user2 identified by user2;
create user user3 identified by user3;
create Role Project_Admin IDENTIFIED BY oussama;
grant dba to Project_Admin;
grant Project_Admin to user1;
Create profile HR_Manager limit SESSIONS_PER_USER UNLIMITED;
Create profile Supply_Manager limit SESSIONS_PER_USER UNLIMITED;
alter user user2 Profile  HR_manager ;
alter user user3 Profile  Supply_manager ;
/*--inserting test subject into database--*/
insert into prevliage values (1,'user1','user1');
insert into prevliage values (2,'user2','user2');
insert into prevliage values (3,'user3','user3');
insert into categorie values(1,'ous');
insert into Departement values(1,'department informatique','boumdjoud','amel');
insert into employe values(1,'mahdjour','oussama','enginner','information system enginner',1);
insert into accounts values(1,'ous','ous',1);
insert into produit values(1,'ous',2,'12/may/2021',3,'oki',1);
commit;
desc dba_users;
select * from dba_users;
SELECT * FROM  accounts where username='ous' and password= 'ous';

select * from prevliage;
