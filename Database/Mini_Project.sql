 /*--creating database--*/
create table Departement (
    Code_dep int not null , 
    Intitule_dep varchar (50) not null, 
    Nom_chef varchar (50) not null,
    Prenom_chef varchar (50) not null,
    active NUMBER(1) DEFAULT 1,
    PRIMARY KEY (Code_dep));
create table EMPLOYE (
    Code_emp int not null,
    Nom_emp varchar(50) not null,
    Prenom_emp varchar(50) not null,
    Grade_emp varchar(50) not null,
    Fonction varchar(50) not null,
    Code_dep int not null,
    active NUMBER(1) DEFAULT 1,
    PRIMARY KEY (Code_emp),
    FOREIGN key (Code_dep)REFERENCES Département(Code_dep) );
create table CATEGORIE (
    num_cat int not null ,
    categorie varchar (50) not null,
    active NUMBER(1) DEFAULT 1,
    PRIMARY KEY (num_cat));
create table Produit ( 
    Code_PRO int not null , 
    Designation varchar(100) not null , 
    Qte_stock int not null, 
    Date_stock date not null,
    seuil int ,
    type_pro varchar(50) not null,
    num_cat int not null,
    active NUMBER(1) DEFAULT 1,
    PRIMARY KEY (Code_PRO),
    FOREIGN KEY (num_cat) REFERENCES CATEGoRIE(num_cat));
create table FOURNISSEUR (
    Code_fournisseur int not null , 
    Nom_fournisseur varchar(50) not null , 
    Num_compte int not null ,
    Num_Tel int not null,
    active NUMBER(1) DEFAULT 1,
    Primary Key (Code_Fournisseur));
create table Bon_SORTIE (
    Num_bso int not null , 
    Date_sor date not null,
    Code_emp int not null,
    active NUMBER(1) DEFAULT 1,
    Primary key (Num_bso),
    Foreign Key (Code_emp) REFERENCES EMPLOYE (Code_emp) ON DELETE CASCADE);
Create table SE_REFERE ( 
    Num_bso int not null, 
    Code_pro int not null ,
    Qte_sortie int not null, 
    active NUMBER(1) DEFAULT 1,
    Primary key (Num_bso,Code_pro),
    Foreign key (Num_bso) REFERENCES Bon_Sortie(Num_Bso) ON DELETE CASCADE,
    Foreign key (Code_Pro) REFERENCES Produit(Code_pro) ON DELETE CASCADE); 
create table Bon_AFFECTATION (
    Num_baf int not null, 
    Date_aff date not null, 
    Code_emp int not null,
    active NUMBER(1) DEFAULT 1,
    Primary key (Num_baf),
    FOREIGN KEY (Code_emp) REFERENCES EMPLOYe(Code_emp) ON delete cascade );
Create table CONCERNER (
    Num_baf int not null ,
    Code_PRO int not null, 
    Qte_aff int not null,
    active NUMBER(1) DEFAULT 1,
    Primary key (Num_baf,Code_pro),
    Foreign key (Num_baf) REFERENCES Bon_AFFECTATION(Num_baf) ON DELETE CASCADE,
    Foreign key (Code_Pro) REFERENCES Produit(Code_pro) ON DELETE CASCADE);
Create table COMMANDE (
    Num_bco int not null,
    Date_com date not null , 
    Code_fournisseur int not null,
    active NUMBER(1) DEFAULT 1,
    Primary Key (Num_bco),
    FOREIGN key (Code_fournisseur) REFERENCES fournisseur(code_fournisseur)on delete cascade);
create table CONTENIR ( 
    Num_bco int not null ,
    Code_PRO int not null , 
    Qte_cde int not null,
    active NUMBER(1) DEFAULT 1,
    Primary key (Num_bco,Code_pro),
    Foreign key (Num_bco) REFERENCES COMMANDE(Num_bco) ON DELETE CASCADE,
    Foreign key (Code_Pro) REFERENCES Produit(Code_pro) ON DELETE CASCADE);
create table Bon_LIVRAISON (
    Num_bliv int not null , 
    Date_liv date not null,
    quantite int not null,
    active NUMBER(1) DEFAULT 1,
    PRIMARY KEY (Num_bliv));
create table RENFERMER (
    Num_bliv int not null,
    Code_PRO int not null,
    Qte_liv int not null,
    active NUMBER(1) DEFAULT 1,
    Primary key (Num_bliv,Code_pro),
    Foreign key (Num_bliv) REFERENCES Bon_livraison(Num_bliv) ON DELETE CASCADE,
    Foreign key (Code_Pro) REFERENCES Produit(Code_pro) ON DELETE CASCADE);
create table accounts (
    id_user int not null,
    username  varchar(50) not null,
    password varchar(100) not null,
    id_prev int not null,
    active NUMBER(1) DEFAULT 1,
    PRIMARY KEY (id_user),
    Foreign key (id_user) REFERENCES employe(code_emp) ON DELETE CASCADE,
    Foreign key (id_prev) REFERENCES prevliage(id_pre) ON DELETE CASCADE);
create table prevliage(
    id_pre int not null,
    pre_name varchar(20)not null,
    active NUMBER(1) DEFAULT 1,
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
/*-- create synonyme --*/
create public synonym PRO for produit;
create public synonym COMM for commande;
create public synonym BLIV for bon_livraison;
create public synonym BSOR for bon_sortie;
create public synonym BAFF for bon_affectation;
create public synonym EMPY for employe;
create public synonym FRNS for fournisseur;
create public synonym DPRTM for departement;
/*--creation of vue into database--*/
create  materialized view line_command refresh on commit as
  select
    CONTENIR.Num_bco     Num_commande ,
    CONTENIR.Qte_cde     Qte  ,
    produit.designation product_name, 
    CONTENIR.active  active
  from
    CONTENIR , produit
  where
   produit.Code_PRO=  CONTENIR.Code_PRO ;
create materialized view line_sortie refresh on commit as
  select
    SE_REFERE.Num_bso     Num_commande ,
    SE_REFERE.Qte_sortie    Qte  ,
    produit.designation product_name, 
    SE_REFERE.active  active
  from
    SE_REFERE , produit
  where
   produit.Code_PRO=  SE_REFERE.Code_PRO ;
create materialized view line_affectation refresh on commit as
  select
    CONCERNER.Num_baf     Num_commande ,
    CONCERNER.Qte_aff    Qte  ,
    produit.designation product_name, 
    CONCERNER.active  active
  from
    CONCERNER , produit
  where
   produit.Code_PRO=  CONCERNER.Code_PRO ;
create materialized view line_livraison refresh on commit as
  select
    RENFERMER.Num_bliv     Num_commande ,
    RENFERMER.Qte_liv    Qte  ,
    produit.designation product_name, 
    RENFERMER.active  active
  from
    RENFERMER , produit
  where
   produit.Code_PRO=  RENFERMER.Code_PRO ;
create materialized view full_produit refresh on commit as
    select p.code_pro , p.designation , p.date_stock,p.qte_stock,p.seuil,p.type_pro, cat.categorie ,p.active
    from produit p , categorie cat 
    where p.num_cat = cat.num_cat ;
create materialized view full_command refresh on commit as
    select cmd.num_bco , cmd.date_com , f.nom_fournisseur, cmd.active
    from commande cmd , fournisseur f 
    where cmd.code_fournisseur = f.code_fournisseur ;
create materialized view full_employe refresh on commit as
    select emp.code_emp ,emp.nom_emp ,emp.prenom_emp,
    emp.grade_emp,emp.fonction, dep.intitule_dep,emp.active
    from departement dep , employe emp 
    where dep.code_dep = emp.code_dep ;
create materialized view full_Sortie refresh on commit as
    select sr.num_bso,sr.date_sor,emp.nom_emp ,sr.active
    from bon_sortie sr , employe emp 
    where sr.code_emp = emp.code_emp ;
create materialized view full_affectation refresh on commit as
    select sr.num_baf,sr.date_aff,emp.nom_emp ,sr.active
    from bon_affectation sr , employe emp 
    where sr.code_emp = emp.code_emp ; 
/*--inserting test subject into database--*/
insert into prevliage values (1,'user1','user1');
insert into prevliage values (2,'user2','user2');
insert into prevliage values (3,'user3','user3');
insert into categorie values(1,'ous');
insert into Departement values(1,'department informatique','boumdjoud','amel');
insert into employe values(1,'mahdjour','oussama','enginner','information system enginner',1,1);
insert into employe values(2,'ok','oki','enginner','information system enginner',1,1);
insert into employe values(3,'o','k','enginner','information system enginner',1,1);
insert into accounts values(1,'ous','ous',1);
insert into accounts values(2,'oki','oki',2,1);
insert into accounts values(3,'k','k',3,1);
insert into produit values(1,'ous',2,'12/may/2021',3,'oki',1);
insert into fournisseur values (1,'oussama',11,21,1);
commit;
UPDATE bon_affectation set  code_emp='1' ,date_aff=TO_DATE('11/Jan/2022', 'dd/MM/yyyy ') where num_baf =2;