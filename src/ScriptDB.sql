CREATE DATABASE IF NOT EXISTS Vols;
use Vols;


CREATE TABLE IF NOT EXISTS Pilote(
	IdPilote int AUTO_INCREMENT PRIMARY KEY,
	Nom VARCHAR(50),
	Prenom VARCHAR(50),
	Adresse VARCHAR(50),
	tel VARCHAR(20),
	DateNaissance DATE,
	DateEmbauche DATE

);



CREATE TABLE IF NOT EXISTS Avion(
	IdAvion INT AUTO_INCREMENT PRIMARY KEY,
	Compagnie VARCHAR(50), 
	Type VARCHAR(50),
	DateMiseMarche DATE
);

CREATE TABLE IF NOT EXISTS Trajet(
	IdTrajet INT AUTO_INCREMENT PRIMARY KEY,
	AeroportDepart VARCHAR(50),
	AeroportArrivee VARCHAR(50),
	duree_vol INT
);

CREATE TABLE IF NOT EXISTS VOL(
	IdVol INT AUTO_INCREMENT PRIMARY KEY,
	Datevol DATE,
	HeureDecalage INT,
	MinuteDecalage INT,
	idPilote INT,
	idAvion INT,
	idTrajet INT,
	CONSTRAINT FK_VOL_PILOTE FOREIGN KEY(idPilote) REFERENCES Pilote(IdPilote),
	CONSTRAINT FK_VOL_AVION FOREIGN KEY(idAvion) REFERENCES Avion(IdAvion),
	CONSTRAINT FK_VOL_TRAJET FOREIGN KEY(idTrajet) REFERENCES Trajet(idTrajet)
);


/*rempler table pilote*/
INSERT INTO Pilote(nom,Prenom,Adresse,tel,DateNaissance,DateEmbauche) VALUES('hassan','zrd','tetouan','0677338223','1997/08/11','2010/03/4');
INSERT INTO Pilote(nom,Prenom,Adresse,tel,DateNaissance,DateEmbauche) VALUES('hamza','tol','casa','074893333','1999/08/11','2016/03/4');
INSERT INTO Pilote(nom,Prenom,Adresse,tel,DateNaissance,DateEmbauche) VALUES('rida','pop','rabat','0677338223','1993/08/11','2012/03/4');
INSERT INTO Pilote(nom,Prenom,Adresse,tel,DateNaissance,DateEmbauche) VALUES('karim','rof','tanger','0677338223','1994/08/11','2014/03/4');
INSERT INTO Pilote(nom,Prenom,Adresse,tel,DateNaissance,DateEmbauche) VALUES('saad','lol','agadir','0677338223','1992/08/11','2011/03/4');

/*rempler table avion*/
INSERT INTO Avion(Compagnie,Type,DateMiseMarche) VALUES('Qatar','VOL','2010/05/02');
INSERT INTO Avion(Compagnie,Type,DateMiseMarche) VALUES('EMIRATES','VOL','2010/05/02');
INSERT INTO Avion(Compagnie,Type,DateMiseMarche) VALUES('ROYAL MAROC','VOL','2010/05/02');
INSERT INTO Avion(Compagnie,Type,DateMiseMarche) VALUES('BEING','VOL','2010/05/02');
INSERT INTO Avion(Compagnie,Type,DateMiseMarche) VALUES('USA','VOL','2010/05/02');

/*rempler table Trajet*/
INSERT INTO Trajet(AeroportDepart,AeroportArrivee,duree_vol) VALUES('RABAT','BARCELONA',2);
INSERT INTO Trajet(AeroportDepart,AeroportArrivee,duree_vol) VALUES('CASA','NEW YORK',2);
INSERT INTO Trajet(AeroportDepart,AeroportArrivee,duree_vol) VALUES('TETOUAN','MADRID',2);
INSERT INTO Trajet(AeroportDepart,AeroportArrivee,duree_vol) VALUES('TANGER','AMESTERDAM',2);
INSERT INTO Trajet(AeroportDepart,AeroportArrivee,duree_vol) VALUES('CASA','BARCELONA',2);
INSERT INTO Trajet(AeroportDepart,AeroportArrivee,duree_vol) VALUES('MADRID','TANGER',2);
INSERT INTO Trajet(AeroportDepart,AeroportArrivee,duree_vol) VALUES('MIAMI','CASA',2);
INSERT INTO Trajet(AeroportDepart,AeroportArrivee,duree_vol) VALUES('LONDON','TETOUAN',2);
INSERT INTO Trajet(AeroportDepart,AeroportArrivee,duree_vol) VALUES('BARCELONA','RABAT',2);

/*rempler table Vol*/
INSERT INTO VOL(Datevol,HeureDecalage,MinuteDecalage,idPilote,idAvion,idTrajet) VALUES('2019/03/12',16,45,1,1,3);
INSERT INTO VOL(Datevol,HeureDecalage,MinuteDecalage,idPilote,idAvion,idTrajet) VALUES('2019/03/12',19,45,5,2,2);
INSERT INTO VOL(Datevol,HeureDecalage,MinuteDecalage,idPilote,idAvion,idTrajet) VALUES('2019/03/13',10,45,1,1,2);
INSERT INTO VOL(Datevol,HeureDecalage,MinuteDecalage,idPilote,idAvion,idTrajet) VALUES('2019/03/14',16,45,3,1,3);
INSERT INTO VOL(Datevol,HeureDecalage,MinuteDecalage,idPilote,idAvion,idTrajet) VALUES('2019/03/14',12,45,1,4,4);

SELECT p.* from vol v inner join pilote p on v.idpilote=p.idpilote where v.idvol=1;
















