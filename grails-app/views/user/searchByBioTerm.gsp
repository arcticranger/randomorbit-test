<html>
    <head>
        <title>Search Hubbub</title>
        <meta name="layout" content="main"/>
    </head>
    <body>

        <formset>
            <legend>searchByBioTerm</legend>

            <g:form action="resultByBioTerm">
                <label for="term">Term</label>
                <g:textField name="term" />
                
                <g:submitButton name="search" value="Search"/>
            </g:form>

        </formset>

    </body>
</html>
