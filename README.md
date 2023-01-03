# default-web-applikation med page controller

## Startkode på 2. semester efterår 2022

Dette repository er lavet i forbindelse med 2. semester på
Datamatikeruddannelsen i Lyngby og på Bornholm efterår 2022.

## Java version
I pom.xml er diverse dependencies valgt, så projektet kan bygges og køres i Java 8. Nyere versioner af 
Java vil formentlig også fungere, men vi har kun testet med version 8 og 11.

## Tomcat
Brug version 9.0.67

## Deployment på Droplet
26/12/2022

## Du skal gøre følgende for at få webapplikationen i luften:

1. Beslut dig for hvad projektets database skal hedde.
2. Først skal du clone projektet eller downloade en zip-fil med projektet til din arbejdsstation.
   1. Clone: `git clone https://github.com/Israa1809/Carport.git`
   2. Slet .git folderen, så du kan gøre projektet til dit eget git-projekt
      1. > `rm -rf .git/`
   3. Opret dit eget git repository:
      1. > `git init`
3. Åbn Workbench og kør en tilpasset  version af sql-filen `carport.sql`, som ligger i mappen `resources`. Den opretter en database med en user-tabel,carport-tabel,material-tabel, part-tabel og carport-tabel.
4. Du skal evt. ændre kodeord til databasen i projektet. Det gøres i filerne: `/persistence/ConnectionPool` i linie 14 og 15. Du skal også ændre i UserMapperTest.
5. Refactor `carport` til dit eget projekt alle de steder, hvor det er relevant. Fx her:
   1. I projektroden
   2. I pom.xml (`artifactId`og `name` elementerne)
6. Til sidst skal du lave en Tomcat konfiguration. Dvs, 
   1. klik på "Add Configuration ..."
   2. Klik på "+" og vælg "Tomcat Server Local".
   3. Klik på "Fix knappen"
   4. Vælg war-exploded som deployment type
   5. Nu kan du klikke på den grønne play-knap for at bygge og køre projektet.
7. Lav et repo på GitHub til dit projekt

## Bemærkninger

### Carport indeholder følgende:


- Javaservlets
- JSP sider. Læg dem i WEB-INF som kun skal tilgås via en servlet.
- En super skrabet css-fil til styling
- Datamapper for alle tabellerne, som anvender en connection pool. Den er package-protected
- Facadeklasser , der bruges til at tilgå dine mappermetoder
- Fejlhåndtering med exceptions for databaseoperationer. Den skriver også til Tomcat log.
- Integrationstest af datamapperen for User.

### Funktionelt kan applikationen:

- Vise en forside hvor brugeren kan vælge længde og bredde til sin carport
- Logge en user på. Der findes to brugere i databasen.
    1. `9` med password: `24566525` (rolle: `user`)
    2. `admin` med password: `1234` (rolle: `admin`)
- Man bliver ført til `ordrevisning.jsp` når man logger ind som user og `WEB-INF/kundeordre.jsp` når man logger ind som admin
- Hvis man indtaster ugyldige data under indlogning, bliver man vist en fejlbesked.
- Logge en bruger af står altid i top højre hjørne og man bliver ført tilbage til `index.jsp` når man klikker på "Log ud"
- Metoden `isRoleAllowed(String role, HttpServletRequest request)` som ligger i pakken `services`. Den tjekker om en given bruger matcher en given rolle.

