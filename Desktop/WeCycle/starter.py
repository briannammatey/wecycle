
##from datetime import datetime, timedelta
##from dateutil.parser import parse
from flask import Flask, request, jsonify
from datetime import datetime

app = Flask(__name__)



class Period:
    
    date_format="%m-%d-%Y"
    def __init__(self, start_date, end_date):
        ## parse the data
        self.start_date = datetime.strptime(start_date, self.date_format).date()
        self.end_date = datetime.strptime(end_date, self.date_format).date()
    
    def calculate_durations(self):
        return(self.end_date- self.start_date).days
    
    def is_irregular(self):
        return self.calculate_duration()>10
    
@app.route("/calculate-period", methods=["POST"])
def calculate_period():
    data=request.get_json()
    start_date = data.get('start_date')
    end_date = data.get('end_date')

    period = Period(start_date, end_date)

    duration = period.calculate_durations
    is_irregular = period.is_irregular()

    result ={
        'start_date':start_date,
        'end_date': end_date,
        'duration':duration,
        'is_irregular': is_irregular


    }
    return jsonify(result), 200
    

    if __name__ == "__main__":
        app.run(debug=True)






