CREATE TABLE maladie
(
    id_maladie INT AUTO_INCREMENT PRIMARY KEY ,
    maladie VARCHAR(100) , 
    loha INT ,
    lelo INT ,
    tenda INT ,
    kibo INT ,
    caca INT ,
    fatigue INT ,
    temperature INT 
);
INSERT INTO maladie (maladie,loha,lelo,tenda,kibo,caca,fatigue,temperature) VALUES ("CORONA",6,6,0,0,0,8,7);
INSERT INTO maladie (maladie,loha,lelo,tenda,kibo,caca,fatigue,temperature) VALUES ("GRIPPE",5,6,0,0,0,6,7);


CREATE TABLE medicament (
    id_medicament  INT AUTO_INCREMENT PRIMARY KEY ,
    medicament VARCHAR(100),
    loha INT ,
    lelo INT ,
    tenda INT ,
    kibo INT ,
    caca INT ,
    fatigue INT ,
    temperature INT ,
    prix FLOAT 
);

SELECT medicament,loha + 1 AS loha2 ,
  lelo + 0 AS lelo2 , tenda + 0 AS tenda2, 
  kibo + 0 AS kibo2, caca + 0 AS caca2, 
  fatigue + 1 AS fatigue2, temperature + 0 AS temperature2 ,
  prix
  FROM medicament 
ORDER BY  loha2 + lelo2 + tenda2 + kibo2 + caca2 + fatigue2 + temperature2    ,prix ASC LIMIT  1;
