<html>
    <head>
        <title>Advanced Search</title>
        <meta name="layout" content="main"/>
    </head>
    <body>

        <formset>
            <legend>example of radioGroup using enum classes</legend>


            <g:form action="radioResults">

                   build: <g:radioGroup name="build"
                          values="${randomorbit.test.BuildEnum.values()}"
                          labels="${randomorbit.test.BuildEnum.values()*.name()}" 
                          value="${buildInstance?.type?.name()}">
                          ${it.radio} <g:message code="${it.label}" />&nbsp;
                     </g:radioGroup> <br><br>

                   hair: <g:radioGroup name="hair"
                          values="${randomorbit.test.HairEnum?.values()}"
                          labels="${randomorbit.test.HairEnum.values()*.name()}"
                          value="${hairInstance?.type?.name()}">
                          ${it.radio} <g:message code="${it.label}" />&nbsp;
                     </g:radioGroup> <br><br>

                   ethnic: <g:radioGroup name="ethnic"
                          values="${randomorbit.test.EthnicEnum?.values()}"
                          labels="${randomorbit.test.EthnicEnum.values()*.name()}"
                          value="${ethnicInstance?.type?.name()}">
                          ${it.radio} <g:message code="${it.label}" />&nbsp;
                     </g:radioGroup> <br><br>

                     <g:submitButton name="search" value="Search"/>


            </g:form>

        </formset>

    </body>
</html>
