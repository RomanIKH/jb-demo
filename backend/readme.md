# Backend

приложение запускается по дефолту на порту 8081
http://localhost:8081/

## Description

* способ авторизации - Form based
* Реалезовано иерархия ролей стандартными средствами spring security (SecurityConfig.kt)
* Есть 3 ендпоинта(/payload/admin, /payload/reviewer, /payload/user), котрые доступны определеной роли (или роли выше по иерархии)
* Реалезована возможность создать нового пользователя/ менять пароль пользователя
* файл data.sql содержит пользователей, которые создаются автоматически при старте приложения.
* пароль по умолчанию для всех пользователей: "test"
* Logout реализован