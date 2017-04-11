# Timetable substitution
Projekt zaliczeniowy z przedmiotu IO2

## Konfiguracja

### Wymagania
* Zainstalowany maven 
* Java 8

### Uruchomienie

#### timetable-substitution-impl
Żeby uruchomić aplikację Spring Bootową należy przejść do katalogu timetable-substitution-impl i wykonać następujące polecenie 
`mvn spring-boot:run`, bądź uruchomić w inny sposób (np. korzystając z IDE) cykl życia aplikacji spring-boot:run.

#### front-end
Ta część projektu korzysta z Node.js, które może zostać pobrane do projektu przy pomocy mavena. Aby to zrobić należy wykonać następujące polecenie
`mvn frontend:install-node-and-npm`.

Kolejnym etapem jest pobranie lokalnie zależności, które są potrzebne do zbudowania aplikacji. Możliwość tą zapewnia polecenie`mvn frontend:npm`.
Proces ten może trochę potrwać ze względu na sporą ilość zależności.

Aby zbudować aplikację należy wywołać polecenie `mvn frontend:gulp`. Polecenie wywoła proces budowy aplikacji oraz uruchomi lokalny serwer, który będzie 
serwował aplikację. Serwer będzie również nasłuchwiał zmian w plikach źródłowych i przebudowywał projekt na bieżąco. Nowo dodane pliki nie są nasłuchiwane.
W razie problemów należy wyłączyć proces `CTRL + C` i uruchomić go ponownie.

TL:DR

`mvn frontend:install-node-and-npm`

`mvn frontend:npm`

`mvn frontend:gulp`

Powyższa konfiguracja jest obecnie wyłączona. Należy użyć gulpa przez npm

## Specyfikacja
#### timetable-substitution-impl
Wykorzystuje framework Spring. Wystawia punkty końcowe do poboru danych. 
Projekt napisany tak by wspierał paradygmat REST.

#### front-end
Wykorzystuje framework React.js. Napisany przy użyciu ECMAScript 6.
Aplikacja javascriptowa komunikująca się z back-endem.

# Autorzy
* Adrian Kosiński
* Anna Maziejuk
* Kamil Jankowski
