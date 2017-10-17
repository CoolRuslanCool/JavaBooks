DROP TABLE IF EXISTS book;
CREATE TABLE book(
  id INT(11) NOT NULL AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  description VARCHAR(255) NOT NULL,
  author VARCHAR(100) NOT NULL,
  isbn VARCHAR(20) NOT NULL,
  printYear INT NOT NULL,
  readAlredy BOOLEAN NOT NULL,
PRIMARY KEY (id))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;
INSERT INTO book (title, description, author, isbn, printYear, readAlredy)
VALUES ('Как Незнайка был музыкантом.','В нашей стране нет ни одного человека, который не знал бы имени Николая Николаевича Носова.','Николай Носов.','978-5-389-07233-6',2014,FALSE),
  ('Песочные часы.','Вениамину Каверину чудесным образом удалось соединить в сказке реальность и фантастику. Главные герои - обыкновенные школьники, с недостатками, как у всех детей: один болтлив, второй трусоват и рассеян, третий - хвастунишка...','978-5-9268-1610-2','Вениамин Каверин.',2014,FALSE),
  ('Конец света. Первые итоги.','"Книги - это бумажные тигры с картонными зубами, это усталые хищники, которые вот-вот попадут на обед другим зверям. Зачем упираться, продолжая читать эти неудобные штуки?','Фредерик Бегбедер.','978-5-389-07164-3',2014,FALSE),
  ('Холодное сердце','"Холодное сердце" - самое романтическое произведение знаменитого немецкого сказочника Вильгельма Гауфа в пересказе Т. Габбе и А. Любарской. Молодой угольщик Петер Мунк мечтает о богатстве и готов на все, чтобы получить его...','Вильгельм Гауф.','978-5-353-03358-5',2008,FALSE),
  ('Дневник дизайнера-маньяка.','Это книга о дизайнерах и для дизайнеров - откровенный разговор о наболевшем. Сначала она существовала в виде сетевого дневника, который для издания на бумаге был переписан и снабжен иллюстрациями.','Яна Франк.','978-5-98062-073-8',2014,false),
  ('Мужчина на расстоянии','Когда хозяйка книжной лавки Кей Бартольди вступила в переписку с незнакомцем, заказавшим у нее редкие книги, она и подумать не могла, сколь опасны бывают подобные связи...','Панколь Катрин.','978-5-17-073801-4',2011,FALSE),
  ('Сказки и истории.','В издании воспроизводится 230 иллюстраций знаменитого датского художника и одного из лучших иллюстраторов Андерсена — Ганса Христиана Тегнера.','Христиан Андерсен.','978-5-9922-2098-8',2015,FALSE),
  ('Витя Малеев в школе и дома.','Витя Малеев - школьный тунеядец и домашний забияка. Не хочет учиться, а хочет… Правильно! Стать циркачом.','Николай Носов.','978-5-00108-019-0',2017,FALSE),
  ('Маленький принц.','Трудно быть взрослым. Чувства приходится контролировать, эмоции сдерживать, а правила соблюдать. Кажется, сбежать обратно в мир детства почти невозможно.','Антуан де Сент-Экзюпери.','978-5-699-94610-5',2017,FALSE),
  ('В дороге.','Джек Керуак дал голос целому поколению в литературе, за свою короткую жизнь успел написать около 20 книг прозы и поэзии и стать самым известным и противоречивым автором своего времени.','Джек Керуак.','978-5-389-02111-2',2012,FALSE),
  ('Гроздья гнева','"В душах людей наливаются и зреют гроздья гнева - тяжелые гроздья, и дозревать им теперь уже недолго...".','Джон Стейнбек.','978-5-389-04994-9',2016,FALSE),
  ('О мышах и людях.','"О мышах и людях" - повесть, не выходящая из ТОР-100 "Amazon", наряду с "Убить пересмешника" Харпер Ли, "Великим Гэтсби" Фицджеральда, "1984" Оруэлла.','Джон Стейнбек.','978-5-17-099511-0',2016,FALSE),
  ('Поправка-22.','Прошло полвека со времени первой публикации, но "Поправка-22" по-прежнему остается краеугольным камнем американской литературы и одной из самых знаменитых книг всех времен.','Джозеф Хеллер.','978-5-17-091779-2',2017,FALSE),
  ('Вообрази себе картину.','Один из самых необычных, элегантных и остроумных романов Джозефа Хеллера. Роман, который эффектно балансирует между сюрреалистической фантазией, философской притчей.','Джозеф Хеллер.','978-5-17-066002-5',2010,FALSE),
  ('Жесткий SMM. Выжать из соцсетей максимум.','Чем отличается качественный SMM от того, чем занимаются 99 % компаний? Главным образом тем, что здесь нет места бахвальству размером своей компании.','Дэн С. Кеннеди.','978-5-9614-6179-4',2017,FALSE),
  ('Конверсия. Как превратить лиды в продажи.','Это проверенный практикой пошаговый план, цель которого - привлечь потенциальных клиентов через интернет и превратить их в реальных покупателей.','Крис Смит.','978-5-9614-5982-1',2017,FALSE),
  ('Хочу и буду. Принять себя, полюбить жизнь и стать счастливым.','"Когда человек, которому не нравится его жизнь, осознает или хотя бы начинает подозревать, что дело не в жестокости мира.','Михаил Лабковский.','978-5-9614-6244-9',2017,FALSE),
  ('Главное внимание главным вещам. Жить, любить, учиться и оставить наследие.','Цитата "Вместо того чтобы поискать глубинные, хронические причины проблем, мы снимаем острую боль, порождаемую ими.','Роджер А. Меррилл','978-5-9614-4736-1',2016,FALSE),
  ('Восьмой навык. От эффективности к величию','Цитата "Восьмой навык - это не просто дополнение Семи навыков еще одним, о котором почему-то позабыли. Восьмой навык связан с пониманием значения третьего измерения.','Стивен Р. Кови','978-5-9614-4719-4',2015,FALSE),
  ('Пять правил выдающейся эффективности.','Цитата Занятость не равно продуктивность, действие не равно полезность. "Пять правил выдающейся эффективности" учат делать то, что имеет стратегическую ценность.','Лина Риннэ','978-5-9614-5601-1',2012,FALSE),
  ('Мой продуктивный год.','Цитата "Можете не верить, но апокалипсис с участием зомби происходит прямо сейчас. Если вы выглянете в окно, то вы увидите ходячих мертвецов. Они не могут ни на чем толком сосредоточиться.','Крис Бэйли','978-5-9614-6059-9',2013,FALSE),
  ('Пять правил выдающейся эффективности.', 'Цитата Занятость не равно продуктивность, действие не равно полезность. "Пять правил выдающейся эффективности" учат делать то, что имеет стратегическую ценность.', 'Лина Риннэ', '978-5-9614-5601-1', 2012, FALSE),
('Мой продуктивный год.', 'Цитата "Можете не верить, но апокалипсис с участием зомби происходит прямо сейчас. Если вы выглянете в окно, то вы увидите ходячих мертвецов. Они не могут ни на чем толком сосредоточиться.', 'Крис Бэйли', '978-5-9614-6059-9', 2013, FALSE),
('Вы или хаос.', 'Эта книга - уникальное практическое руководство по построению целостной системы управленческого планирования "с нуля" в рамках всей организации сверху донизу. Александр Фридман.', '	Александр Фридман.', '978-5-98124-678-4', 2016, FALSE),
('Бизнес-процессы: как их описать.', 'Эта книга описывает простую и надежную технологию работы с бизнес-процессами: их описание, отладку, внедрение и дальнейшее совершенствование. Система создана в ходе работы с сотнями компаний России.','Михаил Рыбаков.', '978-5-9907325-0-6', 2012, FALSE)
;