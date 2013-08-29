<html>
    <head>
        <title>Search Hubbub</title>
        <meta name="layout" content="main"/>
    </head>
    <body>

        <formset>
            <legend>searchByUserame.gsp</legend>

            <g:form action="resultByUsername">
                <label for="username">User Id</label>
                <g:textField name="username" />
                
                <g:submitButton name="search" value="Search"/>
            </g:form>

        </formset>

    </body>
</html>
