# Getting Started:
#You'll find the WAR file within this Repo.
This Back end consumes an external API, which one requires a Cookie in order to be able to fetch the data and won´t be blocked by server.
this server is already configure to get the cookie and automatically get the response.
## Alert!!
Don't make more than 1 petition per minute, otherwise the external API will block the IP who is making the petition, and it will respond with a 500 server error (Too many request)
