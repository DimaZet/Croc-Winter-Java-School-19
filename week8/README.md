# Задача 8

Кинотеатр "Места для поцелуев" открыл стриминговый сервис для онлайн-просмотра фильмов. За несколько месяцев работы сервиса накопилась история просмотров разными пользователями и владельцы решили внедрить в него систему рекомендаций, которая предлагала бы пользователям наиболее интересные им фильмы.

У вас есть два файла:

1. Список доступных фильмов. Каждая строка содержит числовой идентификатор фильма и его название, разделенные запятой. Например:
```
1,Мстители: Война бесконечности
2,Хатико
3,Тор: Рагнарёк
4,Унесенные призраками
```

2. История просмотров по всем пользователям сервиса. Каждая строка файла содержит список идентификаторов фильмов, просмотренных одним человеком за все время пользования сервисом. Идентификаторы разделены запятыми. Например:
```
2,1,3
3,1,4
2,2,2,2,2
```

На основе этих данных придумайте и реализуйте алгоритм рекомендаций, который бы для произвольного списка просмотров выдавал список рекомендаций (не больше трех элементов в порядке уменьшения предпочтительности). Алгоритм должен предлагать те фильмы, которые пользователи смотрят чаще всего вместе с указанными в исходном списке.

Указанный в примере набор данных не достаточный для формирования хороших рекомендаций, но для входа "2,1" приемлемым выводом будет "3,4". (Фильмы из списка просмотренных в список рекомендаций попадать не должны.)