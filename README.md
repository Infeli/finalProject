# finalProject
Engeto - final project

Finální projekt v rámci java akademie

Úkolem bylo načíst data, rozparsovat, vyhledat 3 země s nejvyššími sazbami a 3 země s nejnižšími sazbami a vypsat je do konzole - (Já zvolil bonusový úkol a formu vypsání na server)

Zároveň bonusové úkoly implementovat vyhledávání daňových sazeb podle zkratek zemí a vytvořit vlastní HTTP API, které vystaví danou funkcionalitu přes webový server
Zdroj dat: https://euvatrates.com/rates.json

Na tento projekt jsem využil klasicky třídu Country, kde jsem namapoval JSON data pomocí @JsonProperty, vygeneroval get, set, equals, hascode a implemetoval metodu compareTo, která slouží v metodách v rámci vyhledávání pro nejnižší a nejvyšší sazby
Dále třída CountryResponse slouží jako taková wrap Mapa, díky které mohu pracovat s daty, které se nachází přímo v "rates".
Třída CountryController slouží pro volání metod a výstup do API pomocí @GetMapping 
A finální třída CountryService slouží k načtení dat, rozparsování a zároveň obsahuje metody, které vyhledají 3 země s nejvyššími a nejnižšími sazbami + i metodu k vyhledání skrze zkratku
