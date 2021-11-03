
## Security

- No authentication required for most of the requests, only `DELETE`
- Auth token is hardcoded. This is providing authentication credentials to a potential attacker
- Site is HTTP only
- Malicious code can be injected into the page (sending `<script>document.write("Alert");</script>` as one of the fields )

## API responses

- Incorrect HTTP response codes used
    * 201 booking is deleted (should be 200, 202 or 204)
    * 200 is used instead of 201 for a booking creation
    * 500 is used instead of 400 for attempting to submit bad or incomplete data
    * 404 is used instead of 405 for methods that aren't supported (e.g PUT and PATCH)
    * 403 when authentication details aren't provided instead of 401.
    * 405 instead of 404 when deleting and the booking id can't be found
    

## General

- The site is not responsive, so shrinking the browser renders the site unusable
- No success or error messages displayed on the UI
- No labels on fields
- No validation on field length, long names can be entered, which overfills the column
- No pagination on results
- Looks like there is a timeout on returning data, which is set using a random number
