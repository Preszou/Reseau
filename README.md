# Morpion Game project.

Ce repository est le résultat de notre travail concernant le projet sur la sécurisation d'une application utilisant le principe de communication du **client/serveur**.
L'objectif de ce projet consiste à reprendre le jeu du morpion et à sécuriser l'échange de données entre le client et le serveur.


## 1 - Analyse
### 1.1 - Sécuriser une application
Afin de sécuriser notre application, on utilise la **cryptographie**.
Le principe de la cryptographie est de définir une transformation des symboles d’un langage (les lettres ou les mots par exemple) qui soit difficilement inversible, de telle sorte que retrouver le mot original à partir du mot codé devienne une opération difficile à effectuer.

Pour cela, on utilise l'algorithme asymétrique, autrement dit, les clés publiques et privées.

### 1.2 - Architecture de l'application 

*Schéma de l'architecture de l'application :*
![](https://cdn.discordapp.com/attachments/920615644876120065/970275702911934484/Schema_Architecture.drawio.png)

## 2 - Résultat
Étant donné que la première version de notre jeu du morpion faisait correspondre les clients et le serveur à l'aide de l'application ***telnet***, nous avons dû repenser toute l'application à l'aide de notre professeur est organiser le projet de la sorte à avoir physiquement un côté ***client*** et un côté ***serveur***.


Afin que l'utilisateur puisse comprendre pourquoi l'application ne fonctionne pas dans sa globalité, il faut savoir que nous ne sommes pas parvenus à terminer l'application.
En effet, nous n'avons pas su mettre en pratique la dernière partie concernant le déchiffrage de la clé secrète.
 

## 3 - Lancement de l'application
Pour lancer l'application du jeu du morpion, il est nécessaire d'exécuter les commandes suivantes depuis un terminal : 
```
$ java serveur/Serveur
```
```
$ java client/Client1
```
```
$ java client/Client2
```
Dès lors, une fois les deux clients connectés au serveur, le jeu pourra commencer.
