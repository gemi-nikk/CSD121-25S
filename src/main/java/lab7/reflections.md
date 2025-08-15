3.2.1
Yes. In the test testSearchMatchesName, created a mock DataService that returned a fixed list of recipes. The search term “chicken” correctly matched only chicken Soup, and the test checked both the count 1 and the result's name.

3.2.2  
Yes. In the test testNoMatchesFound, the mock data contained Pizza and Cake. finding for tofu got an empty list, and  confirmed that .isEmpty() is right

3.2.3
Yes. In testSearchMatchesDescription, the recipe name didn’t contain the word chicken. The search still got it, displaying that both fields are referred.

3.2.4
Yes. In testSearchCaseInsensitive, the data had chicken pie in lowercase, but I searched for CHICKEN in uppercase. The match was worked, proving that case is ignored.





this lab was all about making code easier to test by designing it with flexibility in mind.  
Instead of locking searchRecipes to one specific database, we used a DataService interface. That simple decision meant I could swap in a real database connection SqliteDataService when running the program, or use a fake "mock" version in tests without changing the method itself.

I liked how Java's interfaces and polymorphism made this possible. As long as something implements DataService even a quick lambda pass it into searchRecipes. In my tests, I designed small mock services that either returned a fixed set of recipes or  threw an error. 
check everything: searching in names, searching in descriptions, ignoring case, handling no results, and dealing with errors gracefully.

Using the Streams API felt cleaner than writing loops. It was just a single filter chain that checked the name and description in lowercase, which kept the code short and readable.

the main takeaway for me is that small design choices like depending on an interface make a huge difference in how testable and adaptable a program is. It also handling errors isn’t just about avoiding crashes ,it’s about keeping the program useful.
