*Prezentarea proiectului*

-> Salut, in acest proiect am implementat un API pentru gestionarea alertelor de sistem, avand la baza
o componenta de management a infrastructurii IT, una pentru managementul grupurilor de monitorizare si 
alta pentru generarea efectiva a alertelor de sistem. Aplicatia utilizeaza mai multe design pattern-uri care
sporesc lizibilitatea, mentenanta si modularizarea codului.

*Design Pattern-uri folosite:

> Singleton - Design pattern-ul *Singleton* a fost utilizat pentru clasa Database deoarece aplicatia necesita
o instanta unica ce reprezinta baza de date interna a aplicatiei. Aici se afla stocate toate serverele, grupurile de
monitorizare cat si alertele din sistem, iar folosirea unei instante unice garanteaza coerenta datelor, prin urmare
acest design pattern fiind o alegere pentru cerintele API-ului.
 
> Builder - Pattern-ul *Builder* a fost folosit pentru construirea obiectelor complexe precum Server si Location, care au atat
atribute obligatorii, cat si atribute optionale. Aceasta abordare avand ca scop cresterea lizibilitatii codului dar si evitarea
constructorilor cu un numar ridicat de parametrii, asigurand creaare unor obiecte valide si usor extensibile.

> Factory - De asemenea pattern-ul *Factory* a fost folosit pentru instantierea obiectelor de tip User, deoarece
tipul concret al utilizatorului (`Admin` sau `Operator`) este determinat dinamic in functie de datele de intrare citite
din fisierul de input. Astfel logica de creeare a utilizatorilor este incapsulata, iar adaugarea de noi tipuri de utilizatori
se poate face fara a afecta restul implementarii.

> Command - Pattern-ul *Command* a fost folosit pentru a inlocui blocurile de cod de tip `switch - case` din metoda "main"
separand fiecare comanda intr-o clasa dedicata si imbunatatind astfel lizibilitatea si modularizarea implementarii. De asemenea
a fost introdus si un Record ("commandTools") in care se afla cateva utilitare comune folosite in handling-ul comenzilor
cum ar fi instanta unica Database, obiectul PrintWriter-ul folosit pentru scrierea in fisierul de output, si lineIndex-ul.
Aceasta functionalitate a fost completata de folosirea pattern-ului *Factory* si in cazul comenzilor, prin intermediul clasei
CommandFactory care primeste ca parametru comanda efectiva si instantiaza obiectul corespunzator comenzii.

-> Prin utilizarea acestor Design Patterns am realizat o implementare modulara si usor de extins, in care responsabilitatile
sunt clar delimitate , iar logica este separata de mecanismele de creeare si procesare a obiectelor/comenzilor. Aceasta 
abordare contribuie la cresterea lizibilitatii codului si faciliteaza mentenanta si extinderea ulterioara a aplicatiei.

*Principii respectate:

> Implementarea respecta principiul encapsularii prin folosirea atributelor de tipul private, alaturi de metode de tip 
getter/setter asociate acestora. 
> Abstractizarea este prezenta prin utilizarea clasei abstracte `User` care defineste structura comuna a utilizatorilor din sistem.
Clasele concrete Admin si Operator extind aceasta clasa si ofera atribute specifice pentru fiecare tip de utilizator.
> Mostenirea este realizata in aceasta implementare prin clasele `Admin` si `Operator` care mostenesc clasa User, preluand
atributele si metodele de baza, extinzandu-le cu functionalitati specifice.
> Polimorfismul este utilizat atat in ierarhia de utilizatori unde obiectele de tip `Admin` sau `Operator` sunt tratate
uniform prin tipul abstract `User`, cat si in mecanismul de parsare a comenzilor. Interfata Command defineste metoda `execute()`
care mai apoi este implementata de fiecare clasa in parte in functie de functionalitatile comenzilor.