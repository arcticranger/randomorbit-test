<html>
    <head>
        <title>Search Results</title>
        <meta name="layout" content="main"/>
    </head>
    <body>

        <h1>resultByPhysicalFeature.gsp</h1>
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
                           Ethnicity
                      </td>

                      <td>
                           Build
                      </td>

                      <td>
                           Hair
                      </td>

                      <td>
                           Headline
                      </td>

                      <td>
                           Bio 
                      </td>

                      <td>
                           City
                      </td>

                      <td>
                           State
                      </td>

                      <td>
                           Country
                      </td>

                      <td>
                           Zipcode 
                      </td>
                </tr>


            <g:each var="user" in="${users}">

                <tr>
                      <td>
                           <g:link action="show" id="${user.id}">${user.username}</g:link>
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
                           ${user.headline}
                      </td>

                      <td>
                           ${user.bio}
                      </td>

                      <td>
                           ${user.location?.city}
                      </td>

                      <td>
                           ${user.location?.state}
                      </td>

                      <td>
                           ${user.location?.country}
                      </td>

                      <td>
                           ${user.location?.zipcode}
                      </td>
                </tr>
                     

            </g:each>
        </ul>

        <g:link action='searchByPhysicalFeature'>Search Again</g:link>

    </body>
</html>
