# TP MongoDB

Quelles sont les limites d'une BDD orientées document ?

On ne retrouve pas toujours d'équivalent entre les requetes d'une base de donnée relationnelle avec une base NoSQL.

Atomicité, Cohérence, Isolation, Durabilité ne sont obligatoirement respecté.

Les commandes utiles :

* show dbs : liste le noms des bases de données
* use 'NOMBASE' : permet d'acceder à la base
* show collections 'NOMBASE' : permet de récuperer les collections dans la base
* db.'NOMCOLLECTION'.find() : permet de récuperer les données d'une collection
