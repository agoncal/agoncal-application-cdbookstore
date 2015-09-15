-- CATEGORY
INSERT INTO CATEGORY (id, version, name) VALUES (-1, 1, 'Arts & Photography');
INSERT INTO CATEGORY (id, version, name) VALUES (-2, 1, 'Biographies & Memoirs');
INSERT INTO CATEGORY (id, version, name) VALUES (-3, 1, 'Business & Money');
INSERT INTO CATEGORY (id, version, name) VALUES (-4, 1, 'Comics & Graphic Novels');
INSERT INTO CATEGORY (id, version, name) VALUES (-5, 1, 'Computers & Technology');
INSERT INTO CATEGORY (id, version, name) VALUES (-6, 1, 'Cookbooks, Food & Wine');
INSERT INTO CATEGORY (id, version, name) VALUES (-7, 1, 'Engineering & Transportation');
INSERT INTO CATEGORY (id, version, name) VALUES (-8, 1, 'Health, Fitness & Dieting');
INSERT INTO CATEGORY (id, version, name) VALUES (-9, 1, 'Literature & Fiction');
INSERT INTO CATEGORY (id, version, name) VALUES (-10, 1, 'Mystery, Thriller & Suspense');
INSERT INTO CATEGORY (id, version, name) VALUES (-11, 1, 'Science & Math');
INSERT INTO CATEGORY (id, version, name) VALUES (-12, 1, 'Science Fiction & Fantasy');

-- GENRE
INSERT INTO GENRE (id, version, name) VALUES (-1, 1, 'Alternative Rock');
INSERT INTO GENRE (id, version, name) VALUES (-2, 1, 'Blues');
INSERT INTO GENRE (id, version, name) VALUES (-3, 1, 'Classical Music');
INSERT INTO GENRE (id, version, name) VALUES (-4, 1, 'Classic Rock');
INSERT INTO GENRE (id, version, name) VALUES (-5, 1, 'Country');
INSERT INTO GENRE (id, version, name) VALUES (-6, 1, 'Indie Music');
INSERT INTO GENRE (id, version, name) VALUES (-7, 1, 'Jazz');
INSERT INTO GENRE (id, version, name) VALUES (-8, 1, 'Latin Music');
INSERT INTO GENRE (id, version, name) VALUES (-9, 1, 'Pop');
INSERT INTO GENRE (id, version, name) VALUES (-10, 1, 'R&B');
INSERT INTO GENRE (id, version, name) VALUES (-11, 1, 'Reggae');
INSERT INTO GENRE (id, version, name) VALUES (-12, 1, 'Rock');
INSERT INTO GENRE (id, version, name) VALUES (-13, 1, 'Psychedelic');
INSERT INTO GENRE (id, version, name) VALUES (-14, 1, 'World Music');

-- LABEL
INSERT INTO LABEL (id, version, name) VALUES (-2, 1, 'EMI');
INSERT INTO LABEL (id, version, name) VALUES (-3, 1, 'Sony');
INSERT INTO LABEL (id, version, name) VALUES (-4, 1, 'BMG');
INSERT INTO LABEL (id, version, name) VALUES (-5, 1, 'Universal Music Group');
INSERT INTO LABEL (id, version, name) VALUES (-6, 1, 'PolyGram');
INSERT INTO LABEL (id, version, name) VALUES (-7, 1, 'Apple');
INSERT INTO LABEL (id, version, name) VALUES (-8, 1, 'Parlophone');

-- PUBLISHER
INSERT INTO PUBLISHER (id, version, name) VALUES (-1, 1, 'Pearson');
INSERT INTO PUBLISHER (id, version, name) VALUES (-2, 1, 'Hachette Livre');
INSERT INTO PUBLISHER (id, version, name) VALUES (-3, 1, 'Wiley');
INSERT INTO PUBLISHER (id, version, name) VALUES (-4, 1, 'Oxford University Press');
INSERT INTO PUBLISHER (id, version, name) VALUES (-5, 1, 'Harlequin');
INSERT INTO PUBLISHER (id, version, name) VALUES (-6, 1, 'Flammarion');
INSERT INTO PUBLISHER (id, version, name) VALUES (-7, 1, 'Groupe Gallimard');
INSERT INTO PUBLISHER (id, version, name) VALUES (-8, 1, 'APress');
INSERT INTO PUBLISHER (id, version, name) VALUES (-9, 1, 'O Reilly');
INSERT INTO PUBLISHER (id, version, name) VALUES (-10, 1, 'Pottermore');

-- AUTHOR
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-1, 1, 'Nigel', 'Deakin', 1, 'Nigel Deakin is specification lead for JMS 2.0 (JSR 343) and a principal member of technical staff at Oracle.');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-2, 1, 'Fred', 'Rowe', 1, 'Fred is the WebSphere Architect for a number of Application Server components including those responsible for JEE managed concurrency, JCA (Java Connector Architecture), and database connectivity and connection management. Fred has worked at IBM for 10...');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-3, 1, 'Kinman', 'Chung', 1, 'Spec lead for JSR 341, EL 3.0. Formerly a Tomcat committer. Currently a developer in Glassfish, working on web container, JSP and EL.');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language) VALUES (-4, 1, 'Linda', 'Demichiel', 1);
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-5, 1, 'Arun', 'Gupta', 1, 'Arun Gupta is a Java evangelist working at Oracle. He works to create and foster the community around Java EE, GlassFish, and WebLogic. He has been with the Java EE team since its inception and contributed to all releases. Arun has extensive world wide...');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-6, 1, 'Lincoln', 'Baxter III', 1, 'Lincoln Baxter, III is a Research Engineer at Red Hat, working on JBoss open-source projects; most notably as project lead for JBoss Forge.');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-7, 1, 'Ed', 'Burns', 1, 'Ed Burns is a Senior Staff Engineer for Oracle Corporation where he chairs the JSR 344 (JSF 2.2) Expert Group and contributes to the open source Mojarra project. He is the author of two books published by McGraw-Hill: Secrets of the Rock Star Programme...');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-8, 1, 'Roger', 'Kitain', 1, 'Roger Kitain is an Engineer at Oracle Corporation where he spent the last 15 years working with web technologies. He started working on JavaServer Faces in 2001 as a member of the implementation team and has co-led the specification for JSF since 1.1, ...');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-9, 1, 'Antonio', 'Goncalves', 0, 'Antonio is a senior developer specialized in Java/Java EE. As a consultant he advises customers and helps them in defining and developing their software architecture. This Java Champion is also the founder of the very successful Paris JUG, Devoxx Franc...');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-10, 1, 'Adam', 'Bien', 6, 'Consultant and author Adam Bien is an Expert Group member for the Java EE 6 / 7, EJB 3.X, JAX-RS and JPA 2.X JSRs. He has worked with Java technology since JDK 1.0 and with Servlets/EJB 1.0 and is now an architect and developer for Java SE and Java EE ...');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-11, 1, 'Emmanuel', 'Bernard', 0, 'Emmanuel Bernard is data platform architect at JBoss by Red Hat where he oversees data projects of the Red Hat''s middleware and is member of the Hibernate team. Emmanuel has spent a few years in the retail industry as developer and architect where he ...');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-12, 1, 'Jitendra', 'Kotamraju', 1, 'Jitendra Kotamraju is a software engineer at Oracle. He has been contributing to the many Java EE technologies and GlassFish projects for the last 8 years. He was the specification and implementation lead of JAX-WS 2.2. At present, he is the specificat...');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-13, 1, 'Mike', 'Keith', 1, 'Mike Keith has been an enterprise, distributed systems and persistence expert for over 20 years. He is a Java and Enterprise Architect at Oracle and contributes to Java EE and many of the subspecifications that make up the enterprise Java portfolio. He...');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-14, 1, 'Anthony', 'Lai', 1, 'Anthony Lai is a principal member of technical staff at Oracle. He is the specification lead for JSR 236 - Concurrency Utilities for Java EE 1.0, and was previously a member of the J2EE Connector Architecture 1.5 specification (JSR 112) expert group.');
INSERT INTO AUTHOR (id, version, first_name, last_name, preferred_language, bio) VALUES (-15, 1, 'J. K.', 'Rowling', 1, 'J K (Joanne Kathleen) Rowling was born in the summer of 1965 at Yate General Hospital in England and grew up in Chepstow, Gwent where she went to Wyedean Comprehensive. Jo left Chepstow for Exeter University, where she earned a French and Classics degree, and where her course included one year in Paris');

-- BOOK
INSERT INTO ITEM (discriminator, id, version, isbn, title, language, unit_cost, nb_of_pages, publication_date, category_id, publisher_id, small_image_url, description) VALUES ('B', -1, 1, '143024626X', 'Beginning Java EE 7', 1, 49.99, 608, '2013-06-26', -5, -8, 'http://ecx.images-amazon.com/images/I/518rDqWwjhL._SL400_.jpg', 'Java Enterprise Edition (Java EE) continues to be one of the leading Java technologies and platforms. Beginning Java EE 7 is the first tutorial book on Java EE 7. Step by step and easy to follow, this book describes many of the Java EE 7 specifications...');
INSERT INTO ITEM (discriminator, id, version, isbn, title, language, unit_cost, nb_of_pages, publication_date, category_id, publisher_id, small_image_url, description) VALUES ('B', -2, 1, '1430250011', 'Oracle Certified Master Java EE 7 Architect', 0, 49.99, 700, '2014-01-15', -5, -8, 'http://ecx.images-amazon.com/images/I/51maX4w9q9L._SL400_.jpg', 'Oracle Certified Master, Java Enterprise Architect Java EE 7 Certification Guide is a practical hands on guide for those looking to achieve the Master certification. It deals with the different technological aspects necessary to prop up the understandi...');
INSERT INTO ITEM (discriminator, id, version, isbn, title, language, unit_cost, nb_of_pages, publication_date, category_id, publisher_id, small_image_url, description) VALUES ('B', -3, 1, '1449370179', 'Java EE 7 Essentials', 1, 39.99, 362, '2013-09-03', -5, -9, 'http://ecx.images-amazon.com/images/I/51XmtrCbZ5L._SL400_.jpg', 'Get up to speed on the principal technologies in the Java Platform, Enterprise Edition 7, and learn how the latest version embraces HTML5, focuses on higher productivity, and provides functionality to meet enterprise demands. Written by Arun Gupta, a k...');
INSERT INTO ITEM (discriminator, id, version, isbn, title, language, unit_cost, nb_of_pages, publication_date, category_id, publisher_id, small_image_url, description) VALUES ('B', -4, 1, '1430244259', 'Java EE 7 Recipes: A Problem-Solution Approach', 1, 49.99, 748, '2013-05-22', -5, -9, 'http://ecx.images-amazon.com/images/I/51MKty2UO2L._SL400_.jpg', 'Java EE 7 Recipes takes an example-based approach in showing how to program Enterprise Java applications in many different scenarios. Be it a small-business web application, or an enterprise database application, Java EE 7 Recipes provides effective an...');
INSERT INTO ITEM (discriminator, id, version, isbn, title, language, unit_cost, nb_of_pages, publication_date, category_id, publisher_id, small_image_url, description) VALUES ('B', -5, 1, '1430258489', 'Introducing Java EE 7: A Look at What''s New', 1, 29.99, 240, '2013-06-26', -5, -8, 'http://ecx.images-amazon.com/images/I/5125O5fSJ1L._SL400_.jpg', 'Introducing Java EE 7:  A Look at What’s New&lt;/em&gt; guides you through the new features and enhancements in each of the technologies comprising the Java EE platform.  Readers of this book will not have to wade through introductory material or infor...');
INSERT INTO ITEM (discriminator, id, version, isbn, title, language, unit_cost, nb_of_pages, publication_date, category_id, publisher_id, small_image_url, description) VALUES ('B', -6, 1, '059035342X', 'Harry Potter and the Philosopher''s Stone', 1, 8.19, 345, '2012-03-27', -12, -10, 'http://ecx.images-amazon.com/images/I/51mAswZUsSL._SL400_.jpg', 'Harry Potter thinks he is an ordinary boy. He lives with his Uncle Vernon, Aunt Petunia and cousin Dudley, who make him sleep in a cupboard under the stairs. Then Harry starts receiving mysterious letters and his life is changed for ever. He is whisked away by a beetle-eyed giant of a man and enrolled in Hogwarts School of Witchcraft and Wizardry. The reason: Harry Potter is a wizard!');
INSERT INTO ITEM (discriminator, id, version, isbn, title, language, unit_cost, nb_of_pages, publication_date, category_id, publisher_id, small_image_url, description) VALUES ('B', -7, 1, 'B007CHVJOA', 'Harry Potter and the Chamber of Secrets', 1, 12.29, 543, '2013-06-26', -12, -10, 'http://ecx.images-amazon.com/images/I/51xdRpW-kUL._SL400_.jpg', 'Harry Potter is a wizard. He is in his second year at Hogwarts School of Witchcraft and Wizardry. The three friends, Harry, Ron and Hermione, are soon immersed in the daily round of Potions, Herbology, Charms, Defence Against the Dark Arts and Quidditch. Then mysterious and scary things start happening. First Harry hears strange voices, and then Ronï¿½s sister, Ginny, disappears');
INSERT INTO ITEM (discriminator, id, version, isbn, title, language, unit_cost, nb_of_pages, publication_date, category_id, publisher_id, small_image_url, description) VALUES ('B', -8, 1, 'B00728DYQ0', 'Harry Potter and the Prisoner of Azkaban', 1, 9.99, 1234, '2013-07-26', -12, -10, 'http://ecx.images-amazon.com/images/I/51MHpSVM38L._SL400_.jpg', 'Harry Potter, along with his best friends, Ron and Hermione, is about to start his third year at Hogwarts School of Witchcraft and Wizardry. Harry can''t wait to get back to school after the summer holidays (who wouldn''t if they lived with the horrible Dursleys?). But when Harry gets to Hogwarts, the atmosphere is tense. There''s an escaped mass murderer on the loose, and the sinister prison guards of Azkaban have been called in to guard the school.');
INSERT INTO ITEM (discriminator, id, version, isbn, title, language, unit_cost, nb_of_pages, publication_date, category_id, publisher_id, small_image_url, description) VALUES ('B', -9, 1, 'B00728DYBA', 'Harry Potter and the Goblet of Fire', 1, 9.99, 234, '2014-01-28', -12, -10, 'http://ecx.images-amazon.com/images/I/51q3Z6UVhxL._SL400_.jpg', 'The summer holidays seem never-ending and Harry Potter can''t wait for the start of the school term. It is his fourth year at Hogwarts School of Witchcraft and Wizardry, and there are spells to learn and (unluckily) Potions and Divination lessons to attend. But Harry needs to be on his guard at all times - his worst enemy is preparing a horrifying fate for him.');
INSERT INTO ITEM (discriminator, id, version, isbn, title, language, unit_cost, nb_of_pages, publication_date, category_id, publisher_id, small_image_url, description) VALUES ('B', -10, 1, 'B00728DYJM', 'Harry Potter and the Order of the Phoenix', 1, 11.27, 235, '2014-02-26', -12, -10, 'http://ecx.images-amazon.com/images/I/51uorsWJqPL._SL400_.jpg', 'Harry Potter is due to start his fifth year at Hogwarts School of Witchcraft and Wizardry. He is desperate to find out why his friends, Ron and Hermione, have been secretive all summer. But before he even gets to school, Harry survives a terrifying encounter with two Dementors, attends a court hearing at the Ministry of Magic and is escorted on a night-time broomstick ride to the secret headquarters of a mysterious group called the Order of the Phoenix');
INSERT INTO ITEM (discriminator, id, version, isbn, title, language, unit_cost, nb_of_pages, publication_date, category_id, publisher_id, small_image_url, description) VALUES ('B', -11, 1, 'B00728DYGA', 'Harry Potter and the Half-Blood Prince', 1, 9.99, 435, '2014-05-02', -12, -10, 'http://ecx.images-amazon.com/images/I/518VwI3U0jL._SL400_.jpg', 'It is Harry Potter sixth year at Hogwarts School of Witchcraft and Wizardry. As Voldemort sinister forces amass and a spirit of gloom and fear sweeps the land, it becomes clear to Harry that he will soon have no choice but to confront his destiny. Can Harry succeed in the death-defying tasks ahead?');
INSERT INTO ITEM (discriminator, id, version, isbn, title, language, unit_cost, nb_of_pages, publication_date, category_id, publisher_id, small_image_url, description) VALUES ('B', -12, 1, 'B00728DY60', 'Harry Potter and the Deathly Hallows', 1, 8.19, 456, '2014-06-12', -12, -10, 'http://ecx.images-amazon.com/images/I/510QvoO3SzL._SL400_.jpg', 'Harry Potter is preparing to leave the Dursleys and Privet Drive for the last time. But the future that awaits him is full of danger, not only for him, but for anyone close to him — and Harry has already lost so much. Only by destroying Voldemort''s remaining Horcruxes can Harry free himself and overcome the Dark Lord''s forces of evil. In a final perilous journey, Harry must find the strength and the will to face a deadly confrontation that is his alone to fight.');

-- MUSICIAN
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-1, 1, 'John', 'Lennon', '1940-10-09', 'Guitar', 'John Winston Ono Lennon, (born John Winston Lennon; 9 October 1940 – 8 December 1980) was an English musician, singer and songwriter who rose to worldwide fame as a founder member of the Beatles, the most commercially successful band in the history of popular music. With Paul McCartney, he formed a songwriting partnership that is one of the most celebrated of the 20th century');
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-2, 1, 'Paul', 'McCartney', '1942-06-10', 'Bass', 'Sir James Paul McCartney, (born 18 June 1942) is an English musician, singer, songwriter, multi-instrumentalist, and composer. With John Lennon, George Harrison and Ringo Starr, he gained worldwide fame as a member of the Beatles, widely regarded as one of the most popular and influential acts in the history of rock music; his songwriting partnership with Lennon is one of the most celebrated of the 20th century. After the band''s break-up, he pursued a solo career and later formed Wings with his first wife, Linda, and Denny Laine.');
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-3, 1, 'Ringo', 'Starr', '1940-07-07', 'Drums', 'Ringo Starr (born Richard Starkey; 7 July 1940) is an English musician, singer, songwriter and actor who gained worldwide fame as the drummer for the Beatles. On most of the band''s albums, he sang lead vocals for one song, including "With a Little Help from My Friends", "Yellow Submarine" and their cover of "Act Naturally". He also wrote the Beatles'' songs "Don''t Pass Me By" and "Octopus''s Garden", and is credited as a co-writer of others, such as "What Goes On" and "Flying"');
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-4, 1, 'George', 'Harrison', '1943-02-25', 'Guitar', 'George Harrison, (25 February 1943 – 29 November 2001) was an English musician, singer and songwriter who achieved international fame as the lead guitarist of the Beatles. Although John Lennon and Paul McCartney were the band''s primary songwriters, most of their albums included at least one Harrison composition, including "While My Guitar Gently Weeps", "Here Comes the Sun" and "Something", which became the Beatles'' second most-covered song.');
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-5, 1, 'Ronnie', 'Wood', '1947-07-01', 'Guitar', 'Ronald David "Ronnie" Wood (born 1 June 1947) is an English rock musician best known as a member of the Rolling Stones since 1975, as well as a former member of the Faces and the Jeff Beck Group.');
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-6, 1, 'Mick', 'Jagger', '1943-07-26', 'Voice', 'Sir Michael Philip "Mick" Jagger (born 26 July 1943) is an English musician, singer, songwriter and actor, best known as the lead vocalist and a founder member of the Rolling Stones.');
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-7, 1, 'Keith', 'Richards', '1943-12-18', 'Guitar', 'Keith Richards (born 18 December 1943) is an English musician, singer, songwriter and founding member of the English rock band the Rolling Stones. Rolling Stone magazine credited Richards for "rock''s greatest single body of riffs" on guitar and ranked him 4th on its list of 100 best guitarists.[1] Fourteen songs Richards wrote with the Rolling Stones'' lead vocalist Mick Jagger are listed among Rolling Stone magazine''s "500 Greatest Songs of All Time".');
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-8, 1, 'Charlie', 'Watts', '1941-06-02', 'Drums', 'Charles Robert "Charlie" Watts (born 2 June 1941) is an English drummer, best known as a member of the Rolling Stones. He is also the leader of a jazz band,[1] a record producer, commercial artist, and horse breeder.');
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-9, 1, 'Nick', 'Mason', '1944-01-27', 'Drums', 'Nicholas Berkeley "Nick" Mason (born 27 January 1944) is an English drummer and composer, best known for his work with Pink Floyd. He is the only constant member of the band since its formation in 1965. Despite solely writing only a few Pink Floyd songs, Mason has co-written some of Pink Floyd''s most popular compositions such as "Echoes" and "Time"');
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-10, 1, 'Roger', 'Waters', '1943-09-06', 'Bass', 'George Roger Waters (born 6 September 1943) is an English musician, singer, songwriter and composer. In 1965, he co-founded the progressive rock band Pink Floyd with drummer Nick Mason, keyboardist Richard Wright and guitarist, singer and songwriter Syd Barrett. Waters initially served as the group''s bassist and co-lead vocalist, but following the departure of Barrett in 1968, he also became their lyricist and conceptual leader.');
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-11, 1, 'Richard', 'Wright', '1943-07-28', 'Keyboard', 'Richard William "Rick" Wright (28 July 1943 – 15 September 2008) was an English musician, singer and songwriter, best known for his career with Pink Floyd.[1] Wright''s richly textured keyboard layers were a vital ingredient and a distinctive characteristic of Pink Floyd''s sound. Wright frequently sang harmony and occasionally lead vocals on stage and in the studio with Pink Floyd (most notably on the songs "Time", "Echoes", "Wearing the Inside Out", "Astronomy Domine" and "Matilda Mother").');
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-12, 1, 'David', 'Gilmour', '1946-03-06', 'Guitar', 'David Jon Gilmour, CBE (born 6 March 1946), is an English musician, singer, songwriter and multi-instrumentalist. He is best-known for his work as the guitarist and co-lead vocalist of the progressive rock band Pink Floyd. It is estimated that as of 2012, the group have sold over 250 million records worldwide, including 74.5 million units sold in the United States');
INSERT INTO MUSICIAN (id, version, first_name, last_name, date_of_birth, preferred_instrument, bio) VALUES (-13, 1, 'Syd', 'Barrett', '1946-01-06', 'Guitar', 'Roger Keith "Syd" Barrett (6 January 1946 – 7 July 2006) was an English musician, singer, songwriter, guitarist, and painter, best remembered as a founding member of the band Pink Floyd. He was the lead vocalist, guitarist, and principal songwriter during the band''s psychedelic years, providing major musical and stylistic direction in their early work. In addition, he is credited with naming the band. Barrett left the group in April 1968 and was briefly hospitalized amid speculation of mental illness exacerbated by drug use');

-- CD
INSERT INTO ITEM (discriminator, id, version, title, unit_cost, genre_id, label_id, small_image_url, description) VALUES ('C', -13, 1, 'Let It Be', 12.99, -9, -2, 'http://ecx.images-amazon.com/images/I/51DQjbR7f8L._SL400_.jpg', 'Let It Be is the 12th and final studio album released by the English rock band the Beatles. It was released on 8 May 1970 by the band''s Apple Records label shortly after the group announced their break-up.');
INSERT INTO ITEM (discriminator, id, version, title, unit_cost, genre_id, label_id, small_image_url, description) VALUES ('C', -14, 1, 'Abbey Road', 15.99, -9, -7, 'http://ecx.images-amazon.com/images/I/615C7P4pmdL._SL400_.jpg', 'Abbey Road is the 11th studio album released by the English rock band the Beatles. It is their last recorded album, although Let It Be was the last album released before the band''s dissolution in 1970. Work on Abbey Road began in April 1969, and the album was released on 26 September 1969 in the United Kingdom, and 1 October 1969 in the United States.');
INSERT INTO ITEM (discriminator, id, version, title, unit_cost, genre_id, label_id, small_image_url, description) VALUES ('C', -15, 1, 'Yellow Submarine', 15.99, -9, -2, 'http://ecx.images-amazon.com/images/I/51oN2Kp-%2BIL._SL400_.jpg', 'Yellow Submarine is the tenth studio album by the Beatles in the United Kingdom, released on Apple Records. It was issued as the soundtrack to the film of the same name, which premiered in the United Kingdom seven months prior to the album''s release.');
INSERT INTO ITEM (discriminator, id, version, title, unit_cost, genre_id, label_id, small_image_url, description) VALUES ('C', -16, 1, 'Magical Mystery Tour', 14.99, -9, -8, 'http://ecx.images-amazon.com/images/I/61HElB1Dx-L._SL400_.jpg', 'Magical Mystery Tour is a double EP and LP by the English rock group the Beatles, produced by George Martin, both including the six-song soundtrack to the 1967 film of the same name. The material was released in the United Kingdom on 8 December 1967 as a six-track double EP on the Parlophone label; in the United States the record, released on 27 November 1967, was an eleven-track LP compiled by Capitol Records, adding the band''s 1967 single releases. The EP was also released in Germany, France, Spain, Yugoslavia, Australia and Japan. [1] The first official release of the recordings in the UK as an eleven-track LP did not occur until 1976');
INSERT INTO ITEM (discriminator, id, version, title, unit_cost, genre_id, label_id, small_image_url, description) VALUES ('C', -17, 1, 'Sgt. Pepper''s Lonely Hearts Club Band', 24.99, -9, -8, 'http://ecx.images-amazon.com/images/I/61nwtHCYOqL._SL400_.jpg', 'Sgt. Pepper''s Lonely Hearts Club Band (often shortened to Sgt. Pepper) is the eighth studio album by English rock band the Beatles. Released in June 1967, the album, which included songs such as "With a Little Help from My Friends", "Lucy in the Sky with Diamonds", and "A Day in the Life", now has over 30 million albums sold. Continuing the artistic maturation seen on the band''s album Revolver (1966), Sgt. Pepper further departed from the conventional pop rock idiom of the time and incorporated balladry, psychedelic, music hall, and symphonic influences');
INSERT INTO ITEM (discriminator, id, version, title, unit_cost, genre_id, label_id, small_image_url, description) VALUES ('C', -18, 1, 'Dark Side of the Moon', 14.99, -13, -8, 'http://ecx.images-amazon.com/images/I/31gnOm4OFlL._SL400_.jpg', 'The Dark Side of the Moon is the eighth studio album by the English progressive rock band Pink Floyd, released in March 1973. It built on ideas explored in the band''s earlier recordings and live shows, but lacks the extended instrumental excursions that characterised their work following the departure in 1968 of founder member, principal composer, and lyricist, Syd Barrett.');
INSERT INTO ITEM (discriminator, id, version, title, unit_cost, genre_id, label_id, small_image_url, description) VALUES ('C', -19, 1, 'Animals', 15.19, -13, -8, 'http://ecx.images-amazon.com/images/I/51npf8BoRwL._SL400_.jpg', 'Animals is the tenth studio album by English progressive rock group Pink Floyd, released in January 1977. A concept album, it provides a scathing critique of the social-political conditions of late 1970s Britain, and presents a marked change in musical style from their earlier work.');
INSERT INTO ITEM (discriminator, id, version, title, unit_cost, genre_id, label_id, small_image_url, description) VALUES ('C', -20, 1, 'Meddle', 17.49, -13, -8, 'http://ecx.images-amazon.com/images/I/51AOjfYBN3L._SL400_.jpg', 'Meddle is the sixth studio album by English progressive rock group Pink Floyd, released on 30 October 1971 by Harvest Records. It was produced between the band''s touring commitments, from January to August 1971. The album was recorded at a series of locations around London, including Abbey Road Studios and Morgan Studios.');
INSERT INTO ITEM (discriminator, id, version, title, unit_cost, genre_id, label_id, small_image_url, description) VALUES ('C', -21, 1, 'Ummagumma', 21.39, -13, -8, 'http://ecx.images-amazon.com/images/I/51yTgCW2X5L._SL400_.jpg', 'Ummagumma is a double album by the English progressive rock band Pink Floyd. It was released on 25 October 1969, through Harvest Records. The first disc is a live album that contains part of their normal set list of the time, while the second contains solo compositions by each member of the band recorded as their fourth studio album.');

-- CD_MUSICIAN
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-13, -1);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-13, -2);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-13, -3);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-13, -4);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-14, -1);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-14, -2);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-14, -3);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-14, -4);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-15, -1);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-15, -2);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-15, -3);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-15, -4);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-16, -1);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-16, -2);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-16, -3);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-16, -4);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-17, -1);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-17, -2);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-17, -3);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-17, -4);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-17, -5);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-17, -6);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-18, -9);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-18, -10);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-18, -11);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-18, -12);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-19, -9);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-19, -10);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-19, -11);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-19, -12);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-20, -9);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-20, -10);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-20, -11);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-20, -12);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-21, -9);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-21, -10);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-21, -11);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-21, -12);
INSERT INTO ITEM_MUSICIAN (item_id, musicians_id) VALUES (-21, -13);

-- COUNTRY
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1000, 'AF','AFGHANISTAN','Afghanistan','AFG','004', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1001, 'AL','ALBANIA','Albania','ALB','008', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1002, 'DZ','ALGERIA','Algeria','DZA','012', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1003, 'AS','AMERICAN SAMOA','American Samoa','ASM','016', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1004, 'AD','ANDORRA','Andorra','AND','020', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1005, 'AO','ANGOLA','Angola','AGO','024', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1006, 'AI','ANGUILLA','Anguilla','AIA','660', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1008, 'AG','ANTIGUA AND BARBUDA','Antigua and Barbuda','ATG','028', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1009, 'AR','ARGENTINA','Argentina','ARG','032', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1010, 'AM','ARMENIA','Armenia','ARM','051', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1011, 'AW','ARUBA','Aruba','ABW','533', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1012, 'AU','AUSTRALIA','Australia','AUS','036', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1013, 'AT','AUSTRIA','Austria','AUT','040', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1014, 'AZ','AZERBAIJAN','Azerbaijan','AZE','031', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1015, 'BS','BAHAMAS','Bahamas','BHS','044', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1016, 'BH','BAHRAIN','Bahrain','BHR','048', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1017, 'BD','BANGLADESH','Bangladesh','BGD','050', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1018, 'BB','BARBADOS','Barbados','BRB','052', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1019, 'BY','BELARUS','Belarus','BLR','112', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1020, 'BE','BELGIUM','Belgium','BEL','056', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1021, 'BZ','BELIZE','Belize','BLZ','084', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1022, 'BJ','BENIN','Benin','BEN','204', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1023, 'BM','BERMUDA','Bermuda','BMU','060', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1024, 'BT','BHUTAN','Bhutan','BTN','064', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1025, 'BO','BOLIVIA','Bolivia','BOL','068', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1026, 'BA','BOSNIA AND HERZEGOVINA','Bosnia and Herzegovina','BIH','070', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1027, 'BW','BOTSWANA','Botswana','BWA','072', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1029, 'BR','BRAZIL','Brazil','BRA','076', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1031, 'BN','BRUNEI DARUSSALAM','Brunei Darussalam','BRN','096', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1032, 'BG','BULGARIA','Bulgaria','BGR','100', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1033, 'BF','BURKINA FASO','Burkina Faso','BFA','854', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1034, 'BI','BURUNDI','Burundi','BDI','108', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1035, 'KH','CAMBODIA','Cambodia','KHM','116', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1036, 'CM','CAMEROON','Cameroon','CMR','120', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1037, 'CA','CANADA','Canada','CAN','124', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1038, 'CV','CAPE VERDE','Cape Verde','CPV','132', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1039, 'KY','CAYMAN ISLANDS','Cayman Islands','CYM','136', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1040, 'CF','CENTRAL AFRICAN REPUBLIC','Central African Republic','CAF','140', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1041, 'TD','CHAD','Chad','TCD','148', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1042, 'CL','CHILE','Chile','CHL','152', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1043, 'CN','CHINA','China','CHN','156', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1046, 'CO','COLOMBIA','Colombia','COL','170', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1047, 'KM','COMOROS','Comoros','COM','174', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1048, 'CG','CONGO','Congo','COG','178', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1049, 'CD','CONGO, THE DEMOCRATIC REPUBLIC OF THE','Congo, the Democratic Republic of the','COD','180', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1050, 'CK','COOK ISLANDS','Cook Islands','COK','184', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1051, 'CR','COSTA RICA','Costa Rica','CRI','188', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1052, 'CI','COTE D IVOIRE','Cote d Ivoire','CIV','384', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1053, 'HR','CROATIA','Croatia','HRV','191', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1054, 'CU','CUBA','Cuba','CUB','192', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1055, 'CY','CYPRUS','Cyprus','CYP','196', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1056, 'CZ','CZECH REPUBLIC','Czech Republic','CZE','203', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1057, 'DK','DENMARK','Denmark','DNK','208', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1058, 'DJ','DJIBOUTI','Djibouti','DJI','262', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1059, 'DM','DOMINICA','Dominica','DMA','212', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1060, 'DO','DOMINICAN REPUBLIC','Dominican Republic','DOM','214', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1061, 'EC','ECUADOR','Ecuador','ECU','218', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1062, 'EG','EGYPT','Egypt','EGY','818', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1063, 'SV','EL SALVADOR','El Salvador','SLV','222', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1064, 'GQ','EQUATORIAL GUINEA','Equatorial Guinea','GNQ','226', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1065, 'ER','ERITREA','Eritrea','ERI','232', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1066, 'EE','ESTONIA','Estonia','EST','233', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1067, 'ET','ETHIOPIA','Ethiopia','ETH','231', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1068, 'FK','FALKLAND ISLANDS (MALVINAS)','Falkland Islands (Malvinas)','FLK','238', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1069, 'FO','FAROE ISLANDS','Faroe Islands','FRO','234', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1070, 'FJ','FIJI','Fiji','FJI','242', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1071, 'FI','FINLAND','Finland','FIN','246', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1072, 'FR','FRANCE','France','FRA','250', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1073, 'GF','FRENCH GUIANA','French Guiana','GUF','254', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1074, 'PF','FRENCH POLYNESIA','French Polynesia','PYF','258', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1076, 'GA','GABON','Gabon','GAB','266', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1077, 'GM','GAMBIA','Gambia','GMB','270', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1078, 'GE','GEORGIA','Georgia','GEO','268', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1079, 'DE','GERMANY','Germany','DEU','276', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1080, 'GH','GHANA','Ghana','GHA','288', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1081, 'GI','GIBRALTAR','Gibraltar','GIB','292', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1082, 'GR','GREECE','Greece','GRC','300', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1083, 'GL','GREENLAND','Greenland','GRL','304', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1084, 'GD','GRENADA','Grenada','GRD','308', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1085, 'GP','GUADELOUPE','Guadeloupe','GLP','312', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1086, 'GU','GUAM','Guam','GUM','316', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1087, 'GT','GUATEMALA','Guatemala','GTM','320', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1088, 'GN','GUINEA','Guinea','GIN','324', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1089, 'GW','GUINEA-BISSAU','Guinea-Bissau','GNB','624', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1090, 'GY','GUYANA','Guyana','GUY','328', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1091, 'HT','HAITI','Haiti','HTI','332', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1093, 'VA','HOLY SEE (VATICAN CITY STATE)','Holy See (Vatican City State)','VAT','336', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1094, 'HN','HONDURAS','Honduras','HND','340', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1095, 'HK','HONG KONG','Hong Kong','HKG','344', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1096, 'HU','HUNGARY','Hungary','HUN','348', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1097, 'IS','ICELAND','Iceland','ISL','352', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1098, 'IN','INDIA','India','IND','356', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1099, 'ID','INDONESIA','Indonesia','IDN','360', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1100, 'IR','IRAN, ISLAMIC REPUBLIC OF','Iran, Islamic Republic of','IRN','364', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1101, 'IQ','IRAQ','Iraq','IRQ','368', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1102, 'IE','IRELAND','Ireland','IRL','372', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1103, 'IL','ISRAEL','Israel','ISR','376', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1104, 'IT','ITALY','Italy','ITA','380', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1105, 'JM','JAMAICA','Jamaica','JAM','388', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1106, 'JP','JAPAN','Japan','JPN','392', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1107, 'JO','JORDAN','Jordan','JOR','400', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1108, 'KZ','KAZAKHSTAN','Kazakhstan','KAZ','398', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1109, 'KE','KENYA','Kenya','KEN','404', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1110, 'KI','KIRIBATI','Kiribati','KIR','296', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1111, 'KP','KOREA, DEMOCRATIC PEOPLE S REPUBLIC OF','Korea, Democratic People s Republic of','PRK','408', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1112, 'KR','KOREA, REPUBLIC OF','Korea, Republic of','KOR','410', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1113, 'KW','KUWAIT','Kuwait','KWT','414', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1114, 'KG','KYRGYZSTAN','Kyrgyzstan','KGZ','417', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1115, 'LA','LAO PEOPLE S DEMOCRATIC REPUBLIC','Lao People s Democratic Republic','LAO','418', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1116, 'LV','LATVIA','Latvia','LVA','428', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1117, 'LB','LEBANON','Lebanon','LBN','422', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1118, 'LS','LESOTHO','Lesotho','LSO','426', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1119, 'LR','LIBERIA','Liberia','LBR','430', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1120, 'LY','LIBYAN ARAB JAMAHIRIYA','Libyan Arab Jamahiriya','LBY','434', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1121, 'LI','LIECHTENSTEIN','Liechtenstein','LIE','438', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1122, 'LT','LITHUANIA','Lithuania','LTU','440', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1123, 'LU','LUXEMBOURG','Luxembourg','LUX','442', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1124, 'MO','MACAO','Macao','MAC','446', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1125, 'MK','MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF','Macedonia, the Former Yugoslav Republic of','MKD','807', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1126, 'MG','MADAGASCAR','Madagascar','MDG','450', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1127, 'MW','MALAWI','Malawi','MWI','454', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1128, 'MY','MALAYSIA','Malaysia','MYS','458', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1129, 'MV','MALDIVES','Maldives','MDV','462', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1130, 'ML','MALI','Mali','MLI','466', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1131, 'MT','MALTA','Malta','MLT','470', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1132, 'MH','MARSHALL ISLANDS','Marshall Islands','MHL','584', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1133, 'MQ','MARTINIQUE','Martinique','MTQ','474', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1134, 'MR','MAURITANIA','Mauritania','MRT','478', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1135, 'MU','MAURITIUS','Mauritius','MUS','480', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1137, 'MX','MEXICO','Mexico','MEX','484', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1138, 'FM','MICRONESIA, FEDERATED STATES OF','Micronesia, Federated States of','FSM','583', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1139, 'MD','MOLDOVA, REPUBLIC OF','Moldova, Republic of','MDA','498', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1140, 'MC','MONACO','Monaco','MCO','492', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1141, 'MN','MONGOLIA','Mongolia','MNG','496', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1142, 'MS','MONTSERRAT','Montserrat','MSR','500', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1143, 'MA','MOROCCO','Morocco','MAR','504', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1144, 'MZ','MOZAMBIQUE','Mozambique','MOZ','508', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1145, 'MM','MYANMAR','Myanmar','MMR','104', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1146, 'NA','NAMIBIA','Namibia','NAM','516', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1147, 'NR','NAURU','Nauru','NRU','520', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1148, 'NP','NEPAL','Nepal','NPL','524', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1149, 'NL','NETHERLANDS','Netherlands','NLD','528', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1150, 'AN','NETHERLANDS ANTILLES','Netherlands Antilles','ANT','530', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1151, 'NC','NEW CALEDONIA','New Caledonia','NCL','540', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1152, 'NZ','NEW ZEALAND','New Zealand','NZL','554', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1153, 'NI','NICARAGUA','Nicaragua','NIC','558', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1154, 'NE','NIGER','Niger','NER','562', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1155, 'NG','NIGERIA','Nigeria','NGA','566', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1156, 'NU','NIUE','Niue','NIU','570', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1157, 'NF','NORFOLK ISLAND','Norfolk Island','NFK','574', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1158, 'MP','NORTHERN MARIANA ISLANDS','Northern Mariana Islands','MNP','580', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1159, 'NO','NORWAY','Norway','NOR','578', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1160, 'OM','OMAN','Oman','OMN','512', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1161, 'PK','PAKISTAN','Pakistan','PAK','586', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1162, 'PW','PALAU','Palau','PLW','585', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1164, 'PA','PANAMA','Panama','PAN','591', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1165, 'PG','PAPUA NEW GUINEA','Papua New Guinea','PNG','598', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1166, 'PY','PARAGUAY','Paraguay','PRY','600', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1167, 'PE','PERU','Peru','PER','604', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1168, 'PH','PHILIPPINES','Philippines','PHL','608', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1169, 'PN','PITCAIRN','Pitcairn','PCN','612', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1170, 'PL','POLAND','Poland','POL','616', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1171, 'PT','PORTUGAL','Portugal','PRT','620', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1172, 'PR','PUERTO RICO','Puerto Rico','PRI','630', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1173, 'QA','QATAR','Qatar','QAT','634', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1174, 'RE','REUNION','Reunion','REU','638', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1175, 'RO','ROMANIA','Romania','ROM','642', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1176, 'RU','RUSSIAN FEDERATION','Russian Federation','RUS','643', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1177, 'RW','RWANDA','Rwanda','RWA','646', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1178, 'SH','SAINT HELENA','Saint Helena','SHN','654', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1179, 'KN','SAINT KITTS AND NEVIS','Saint Kitts and Nevis','KNA','659', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1180, 'LC','SAINT LUCIA','Saint Lucia','LCA','662', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1181, 'PM','SAINT PIERRE AND MIQUELON','Saint Pierre and Miquelon','SPM','666', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1182, 'VC','SAINT VINCENT AND THE GRENADINES','Saint Vincent and the Grenadines','VCT','670', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1183, 'WS','SAMOA','Samoa','WSM','882', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1184, 'SM','SAN MARINO','San Marino','SMR','674', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1185, 'ST','SAO TOME AND PRINCIPE','Sao Tome and Principe','STP','678', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1186, 'SA','SAUDI ARABIA','Saudi Arabia','SAU','682', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1187, 'SN','SENEGAL','Senegal','SEN','686', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1189, 'SC','SEYCHELLES','Seychelles','SYC','690', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1190, 'SL','SIERRA LEONE','Sierra Leone','SLE','694', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1191, 'SG','SINGAPORE','Singapore','SGP','702', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1192, 'SK','SLOVAKIA','Slovakia','SVK','703', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1193, 'SI','SLOVENIA','Slovenia','SVN','705', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1194, 'SB','SOLOMON ISLANDS','Solomon Islands','SLB','090', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1195, 'SO','SOMALIA','Somalia','SOM','706', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1196, 'ZA','SOUTH AFRICA','South Africa','ZAF','710', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1198, 'ES','SPAIN','Spain','ESP','724', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1199, 'LK','SRI LANKA','Sri Lanka','LKA','144', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1200, 'SD','SUDAN','Sudan','SDN','736', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1201, 'SR','SURINAME','Suriname','SUR','740', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1202, 'SJ','SVALBARD AND JAN MAYEN','Svalbard and Jan Mayen','SJM','744', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1203, 'SZ','SWAZILAND','Swaziland','SWZ','748', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1204, 'SE','SWEDEN','Sweden','SWE','752', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1205, 'CH','SWITZERLAND','Switzerland','CHE','756', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1206, 'SY','SYRIAN ARAB REPUBLIC','Syrian Arab Republic','SYR','760', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1207, 'TW','TAIWAN, PROVINCE OF CHINA','Taiwan, Province of China','TWN','158', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1208, 'TJ','TAJIKISTAN','Tajikistan','TJK','762', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1209, 'TZ','TANZANIA, UNITED REPUBLIC OF','Tanzania, United Republic of','TZA','834', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1210, 'TH','THAILAND','Thailand','THA','764', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1212, 'TG','TOGO','Togo','TGO','768', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1213, 'TK','TOKELAU','Tokelau','TKL','772', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1214, 'TO','TONGA','Tonga','TON','776', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1215, 'TT','TRINIDAD AND TOBAGO','Trinidad and Tobago','TTO','780', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1216, 'TN','TUNISIA','Tunisia','TUN','788', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1217, 'TR','TURKEY','Turkey','TUR','792', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1218, 'TM','TURKMENISTAN','Turkmenistan','TKM','795', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1219, 'TC','TURKS AND CAICOS ISLANDS','Turks and Caicos Islands','TCA','796', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1220, 'TV','TUVALU','Tuvalu','TUV','798', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1221, 'UG','UGANDA','Uganda','UGA','800', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1222, 'UA','UKRAINE','Ukraine','UKR','804', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1223, 'AE','UNITED ARAB EMIRATES','United Arab Emirates','ARE','784', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1224, 'GB','UNITED KINGDOM','United Kingdom','GBR','826', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1225, 'US','UNITED STATES','United States','USA','840', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1227, 'UY','URUGUAY','Uruguay','URY','858', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1228, 'UZ','UZBEKISTAN','Uzbekistan','UZB','860', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1229, 'VU','VANUATU','Vanuatu','VUT','548', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1230, 'VE','VENEZUELA','Venezuela','VEN','862', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1231, 'VN','VIET NAM','Viet Nam','VNM','704', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1232, 'VG','VIRGIN ISLANDS, BRITISH','Virgin Islands, British','VGB','092', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1233, 'VI','VIRGIN ISLANDS, U.S.','Virgin Islands, U.s.','VIR','850', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1234, 'WF','WALLIS AND FUTUNA','Wallis and Futuna','WLF','876', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1235, 'EH','WESTERN SAHARA','Western Sahara','ESH','732', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1236, 'YE','YEMEN','Yemen','YEM','887', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1237, 'ZM','ZAMBIA','Zambia','ZMB','894', 1)
INSERT INTO COUNTRY (id, iso_code, name, printable_name, iso3, numcode, version) VALUES (1238, 'ZW','ZIMBABWE','Zimbabwe','ZWE','716', 1)

-- USER
INSERT INTO T_USER (id, version, login, password, first_name, last_name, telephone, email, date_of_birth, user_role) VALUES (1000, 1, 'anakin', 'anakinpwd', 'Anakin', 'Skywalker', '+1 123 3564 4567', 'anakin@skywalker.com', '1935-07-01', 0)
INSERT INTO T_USER (id, version, login, password, first_name, last_name, telephone, email, date_of_birth, user_role) VALUES (1001, 1, 'obiwan', 'obiwanpwd', 'Obi-Wan', 'Kenobi', '+1 765 897 321', 'obiwan@kenobi.com', '1914-04-02', 0)
INSERT INTO T_USER (id, version, login, password, first_name, last_name, telephone, email, date_of_birth, user_role) VALUES (1002, 1, 'luke', 'lukepwd', 'Luke', 'Skywalker', '+1 786 1212 987', 'luke@skywalker.com', '1951-09-07', 0)
INSERT INTO T_USER (id, version, login, password, first_name, last_name, telephone, email, date_of_birth, user_role) VALUES (1003, 1, 'han', 'hanpwd', 'Han', 'Solo', '+1 786 1212 987', 'han@solo.com', '1923-04-12', 0)
