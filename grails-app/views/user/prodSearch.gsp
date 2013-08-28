<%! import randomorbit.test.BuildEnum %> 


<html>
    <head>
        <title>Search Hubbub</title>
        <meta name="layout" content="main"/>
    </head>
    <body>

        <formset>
            <legend>Search for Products</legend>

            <g:form action="prodResults">

                   build: <g:radioGroup name="build"
                          values="${BuildEnum.values()}"
                          labels="${BuildEnum.values()*.name()}"
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


                     <g:radioGroup name="queryType" labels="['And','Or','Not']" values="['and','or','not']" value="and" >
                          ${it.radio} ${it.label}
                     </g:radioGroup>





                     <g:submitButton name="search" value="Search"/>


            </g:form>

        </formset>

    </body>
</html>
