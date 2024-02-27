import logging
from apis import api


class test_api:

    def test_get_api(self):
        url = "https://official-joke-api.appspot.com/random_joke"

        data = api.get(url)
        logging.info(data)



