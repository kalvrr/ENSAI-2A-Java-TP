# ENSAI-2A-Java-TP
Martin GLUMINEAU & Claire ROBIN

### 2.1 : Simulation setup
##### 2.1.1 : 
modification de la probabilité dans application.yml

##### 2.1.2 : 
ajout de "quantity" et "floors/number" dans application.yml. Ajout boucles dans le main pour définir les étages et les ascenceurs.

##### 2.1.3 :
ajout d'un Config.getInt pour récupérer le nombre d'étages

##### 2.1.4 & 2.1.5 :
implémentation de isFull() dans Elevator.java, et utilisation de la nouvelle méthode dans loadPassengers

### 2.2 : Request an elevator
Modification de la méthode requestElevator dans Floor.java
On ajoute Isontheway pour vérifier si un ascenseur est déjà en route auquel cas appuyer sur le bouton ne fait rien, sinon l'ascenceur avec la plus petite liste de destination est envoyé.

### 2.3 : target floor
Modification de la méthode generateTargetFloor() dans Person.java : on sélectionne un floor random parmi les étages où on ne se trouve pas.

### 2.4 : Unit test
##### 2.4.1 :
Il est difficile de tester la méthode isFull() car la capacité de l'ascenceur est modulable. SI on augmente la capacité de l'ascenceur, il peut être difficile de tester le cas 'true', car il faudrait instancier un grand nombre de Personnes pour tester ce cas, personnes qui doivent avoir un étage de départ. Le test, une fois écrit, ne s'adapte pas à la capacité modulable de l'ascenceur.

#####