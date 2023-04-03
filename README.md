# TSInterview
TeamSystem interview project

Prima di iniziare, occorre creare un database nella Local Instance di MySQL lanciando il comando: create database tsusermanagement;

Nel caso in cui si decidesse di rinominare il database, occorre cambiare il parametro spring.datasource.url presente in application.properties.

Nello stesso file sono censiti username e password che ho usato nel mio ambiente locale.
In UserManagerApplication.java ho definito 3 utenti tipo da cui iniziare. Ho supposto che l'id (di tipo Long) di ogni utente sia un id generato in modo sequeziale dal sistema (ho usato la notazione @GeneratedValue(strategy = GenerationType.IDENTITY) per ottenere questo tipo di logica).

Ho usato direttamente Spring Tool Suite 4 come IDE.
Ogni tipo di errore è gestito con delle pagine statiche presenti nella directory /templates.

I log, oltre che in console, vengono stampati anche nel file logs.log.

Esteticamente ho preferito utilizzare i set più basici di bootstrap.
