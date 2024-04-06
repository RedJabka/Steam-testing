# Steam-testing
Working for the first time with selenium and testing steam

## Test case 1
### Steps                        ### Expected results
1. Go to main page                   Main page is opened

2. Click ABOUT                       About page is opened

3. Compare numbers of players        The number of players online is more than the number of players in game

4. Go to store page                  Store page is opened

## Test case 2
### Steps                        ### Results
1. Go to main page                   Main page is opened

2. Hover over “New & Noteworthy”     Top Sellers page is opened
   in page's menu. 
   Wait for a popup. 
   Click on “Top Sellers”                                                                

3. Scroll down.                      Search with Top Sellers page is opened
   Click  “Browse More Top Sellers”        
                            
4. In the right menu                 “SteamOS + Linux” checkbox is set
   check “SteamOS + Linux” checkbox           
                        
5. In the right menu                 “LAN Co-op” checkbox is set
   check “LAN Co-op” checkbox 

6. In the right menu                 “Action” checkbox is set
   check “Action” checkbox
                                     Number of reults match your search is equal to the number games shown

8. Get a name, release date 
   and price for the first game 
   in the list

9. Click the first game             Opened page of the first game
                                    Game data is equal to one we got on step 7

## Test case 3
### Steps                        ### Results
1. Go to main page                   Main page is opened

2. Go to Community Market            Community Market page is opened

3. Open advanced options             Form SEARCH COMMUNITY MARKET is opened

4. Choose next search parameters:
   Game: Dota 2
   Hero: Lifestealer
   Rarity: Immortal

  In Search field enter "golden"

5. Click "Search" button             Next search filters are shown: 
                                     Dota 2 – Lifestealer – Immortal – golden.
                                     First five results have “Golden” in their names.

6. Delete filters:                   List of items is updated
   “golden”, “Dota 2”               

7. Open page of the first item       Check that information of the item is equal to the information on the search page
