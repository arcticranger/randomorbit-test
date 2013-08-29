<html>
    <head>
        <title>Search Results</title>
        <meta name="layout" content="main"/>
    </head>
    <body>

        <h1>Results</h1>
        <p>Searched ${randomorbit.test.User.count()} records
        for items matching <em>${term}</em>.
        Found <strong>${users.size()}</strong> hits.
        </p>

        <ul>
            <g:each var="user" in="${users}">

                <g:link action="show" id="${user.id}">
                      <li>${user.username}</li>
                </g:link>

            </g:each>
        </ul>

        <g:link action='prodSearch'>Search Again</g:link>

    </body>
</html>
