using "thucydides"

import com.baselogic.demos.requirements.Application.MovieSearch.SearchForTitles
import com.baselogic.demos.steps.UserSteps
import com.baselogic.demos.steps.SystemSteps

thucydides.uses_default_base_url "http://www.imdb.com/"
thucydides.uses_steps_from UserSteps
thucydides.uses_steps_from SystemSteps
thucydides.tests_story SearchForTitles

scenario "User can search for movie title",
{
    given "the user opens application",
    {
        system.presentsWelcomePage();
    }
    when "the user performs search for movie title existing in database",
    {
        user.performsSearchForExistingTitle();
    }
    then "the system presents at least one result",
    {
        system.presentsAtLeastOneResult();
    }
}