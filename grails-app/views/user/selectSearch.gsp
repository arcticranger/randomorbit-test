<html>
    <head>
        <title>Advanced Search</title>
        <meta name="layout" content="main"/>
    </head>
    <body>

        <formset>
            <legend>example of selects using enum classes</legend>

            <table>
                <g:form action="selectResults">
                    <tr>
                        <td>Build</td>
                        <td><g:select name="build" from="${randomorbit.test.BuildEnum.values()}" optionValue="name" /></td>
                    </tr>

                    <tr>
                        <td>Ethnic</td>
                        <td><g:select name="ethnic" from="${randomorbit.test.EthnicEnum.values()}" optionValue="name" /></td>
                    </tr>

                    <tr>
                        <td>Hair</td>
                        <td><g:select name="hair" from="${randomorbit.test.HairEnum.values()}" optionValue="name" /></td>
                    </tr>

                    <tr>
                        <td/>
                        <td>
                        <g:submitButton name="search" value="Search"/></td>
                    </tr>
                </g:form>
            </table>

        </formset>

    </body>
</html>
