<html>
    <head>
        <title>Search Hubbub</title>
        <meta name="layout" content="main"/>
    </head>
    <body>

        <formset>
            <legend>searchByRadius</legend>

            <g:form action="resultByRadius">
                <label for="username">Username</label>
                <g:textField name="username" />
                
                <label for="kilometers">Kilometers</label>
                <g:textField name="kilometers" />
                
                <g:submitButton name="search" value="Search"/>
            </g:form>

        </formset>

    </body>
</html>
