![PrimeFaces icon](https://www.primefaces.org/wp-content/uploads/2016/10/prime_logo_new.png)

# Reproducer project demonstrating the broken lazy loading of p:tree in PrimeFaces 8.0 and 9.0-SNAPSHOT

This project uses a `p:tree` to display your root folder of your hard disk. Warning: this demo traverses your entire hard disk,
so you'll want to stop the jetty server after a while. After applying my bug fix, only the folders that are displayed in the browser
are loaded (plus on level below because the algorithms needs to know when to render the "expand" icon).

Before applying my pull request the demo takes many minutes, and the HTML code displayed is broken. The pull request fixes this.

You can execute the sample with <strong>mvn jetty:run</strong> command and hit <strong>http://localhost:8080/primefaces-test</strong> to run the page.

Per default the application uses Mojarra 2.2.x. 
You can also use other versions with the available maven profiles: myfaces22, myfaces23, mojarra23
