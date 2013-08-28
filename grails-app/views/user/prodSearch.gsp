<html>
    <head>
        <title>Search Hubbub</title>
        <meta name="layout" content="main"/>
    </head>
    <body>

        <formset>
            <legend>Search for Products</legend>

            <g:form action="prodResults">

                   myGroup: 


                   <g:radioGroup name="myGroup" values="[1,2,3]">

                        <g:message code="${it.label}" />: ${it.radio}                     

                   </g:radioGroup>

<br><br>

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


                     <g:radioGroup name="queryType" labels="['And','Or','Not']" values="['and','or','not']" value="and" >
                          ${it.radio} ${it.label}
                     </g:radioGroup>





                     <g:submitButton name="search" value="Search"/>


            </g:form>

        </formset>

    </body>
</html>
