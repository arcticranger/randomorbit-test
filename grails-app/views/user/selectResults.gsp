<html>
    <head>
        <title>Search Results</title>
        <meta name="layout" content="main"/>
    </head>
    <body>

        <h1>Select Results</h1>
        <p>Searched ${randomorbit.test.User.count()} records
        for items matching <em>${term}</em>.
        Found <strong>${users.size()}</strong> hits.
        </p>

        <table border>
                <tr>
                      <td>
                           Username
                      </td>

                      <td>
                           Age 
                      </td>

                      <td>
                           Ethnicity
                      </td>

                      <td>
                           Build
                      </td>

                      <td>
                           Hair
                      </td>

                      <td>
                           Bio 
                      </td>
                </tr>


            <g:each var="user" in="${users}">

                <tr>
                      <td>
                           <g:link action="show" id="${user.id}">${user.userId}</g:link>
                      </td>

                      <td>
                           ${user.age}
                      </td>

                      <td>
                           ${user.ethnic}
                      </td>

                      <td>
                           ${user.build}
                      </td>

                      <td>
                           ${user.hair}
                      </td>

                      <td>
                           ${user.bio}
                      </td>
                </tr>
                     

            </g:each>
        </ul>

        <g:link action='selectSearch'>Search Again</g:link>

    </body>
</html>
