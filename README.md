# Alkalmazások fejlesztése
## Alkalmazás rövid ismertetése:

Biztos veled is előfordult már, hogy étteremben vagy bárban a pincér már fut hozzád, mikor még Te a menü első oldalánál tartasz és így kényszerből rendeltél..
Ez mostantól nem fordulhat elő, ha a vendéglátóegységek átt állnak erre a rendszerre!
Ugyan is az asztalodhoz beülve, elektronikus eszközön keresztül Te adod le a rendelést, akkor amikor akarod és olyan megjegyzéssel amivel akarod.
Csak egy gombnyomással, már jelezheted is a pincérnek a kívént rendelésed és az automatizált funkciók miatt már rögtön készítik is a kívánt ételt és (vagy) italodat.
Ha végeztél a rendelésed elfogyasztásával és rendezted a számlát, nincs más dolgod csak jóllakottan távozni!
Dolgozó kollégánk az asztalhoz siet és az asztal nullázásával már fogadják is a következő vendéget!

## Az alkalmazás funkcionális követelményei:

* Vendégek: 
  - Amit csinálhatnak:
    - Hozzáférnek az étlap és itallaphoz.
    - Rendelést adhatnak le.
    - Speciális igényeiket (ételérzékenység) megjegyzésben jelezhetik.
    - Panasszal élhetnek fizetésig.
    - Fizetési szándékukat jelezhetik a pincér felé
  - Amit nem csinálhatnak:
    - Nem minden funkciót érnek el. 
    - Nincs szükség regisztrálásra, ezért a személyükről adatot nem fogunk tárolni. 
    - Nem az alkalmazáson keresztül történik a fizetés.
    
### Dolgozók:

* Pincérek:
  - Regisztrálni kell.
  - Generált kódjuk lesz amivel azonosítani tudjuk őket.
  - Látják a rendelést, panaszt, rendelés elkészültét, fizetési szándékot.
  - Nullázhatják fizetés után az asztal adatait (asztalazonosítót nem).
* Szakácsok:
  - Látják az asztal rendelését, megjegyzéseket.
  - Étel/ital elkészülését jelezheti a pincérnek.
* Az asztaloknak külön azonosítójuk van.
* A dolgozók módosíthatják az étlap/itallapot, hogy egy adott étel/ital elérhető-e vagy sem.

## Az alkalmazás nem funkcionális követelményei:

* Az alkalmazásnak átláthatónak és könnyen kezelhetőnek kell lennie.
* Az alkalmazásnak az adatokat biztonságosan kell kezelnie és tárolnia, kiváltképpen az érzékeny hitelesítő adatokat, amelyek az autentikációhoz szükségesek.
* Az alkalmazásnak gyors válaszidejűnek kell lennie.
* Az alkalmazásnak szinte folyamatosan, minimális rendszerleállásokkal kell működnie a problémák elkerülése miatt.
* A rendszer adatbázisának jól szervezettnek kell lennie, a dinamikusságot elősegítve.

## Szakterületi fogalomjegyzék:

* Étel / ital: felhasználók rendelhetik, dolgozók módosithatják az elérhetőségét.
* Rendelés: Ételek és italok csoportjának kérvényezése az asztalhoz, a rendelés során látszik a végösszeg, és az esetleges alapáron felüli költség.
* Panasz: Amig a vendég nem távozik panaszt tud tenni a pultos/pincér felé, ő pedig továbbithatja ezt az üzletvezetőnek.
* Távozási szándék bejelentése: Ha végzett a vendég, jelezheti a pincéreknek egy gombbal, hogy fizetni és távozni szeretne.

## Szerepkörök:

* (vendég) felhasználó: általános felhasználó, akinek lehetősége van arra, hogy rendelést leadjon az asztalhoz. Értékelheti az ételt, megjegyzést fűzhet ételhez, dolgozóhoz.
* pincér / pultos : olyan felhasználó, aki betekintést nyer az összes asztal rendeléseibe, és nullázni tudja az asztalt.
* üzletvezető: olyan felhasználó, akinek joga van a rendelésekhez fűzött megjegyzéseket módositani, valamint az azokat író felhasználókat moderálni. Egy bejelentkezett felhasználót beállithat dolgozónak, létszámbővités esetén
* rendszeradminisztrátor: olyan felhasználó, akinek joga van pultosokat, pincéreket, üzletvezetőket létrehoznia, moderátori jogokkal bír, valamint természetesen az egyszerű felhasználó jogai is megilletik
