import smtplib
import os
import datetime
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders

PIPELINENO = os.environ.get("PIPELINENO", None)
mail_content = 
'''Hi All,
Please find the attachments of RestAssured API Automation Test Reports.

Regards,
Testing Team
'''
#The mail addresses and password
sender_address = 'srvc.mail@bdiplus.com'
sender_pass = 'srvc.Bdiapp'
receiver_address = 'edmppamex@bdiplus.com'

#Setup the MIME
message = MIMEMultipart()
message['From'] = sender_address
message['To'] = receiver_address
message['Subject'] = "API Automation Test Report Pipeline No " +PIPELINENO
#The subject line
#The body and the attachments for the mail
message.attach(MIMEText(mail_content, 'plain'))
attach_file_name = 'emailable-report.html','API Automation Reports.html'
attach_file = open(attach_file_name, 'rb') # Open the file as binary mode
payload = MIMEBase('application', 'octate-stream')
payload.set_payload((attach_file).read())
encoders.encode_base64(payload) #encode the attachment
#add payload header with filename
payload.add_header('Content-Disposition', "attachment; filename= %s" % attach_file_name)
message.attach(payload)
#Create SMTP session for sending the mail
session = smtplib.SMTP('smtp.office365.com', 587) #use gmail with port
session.starttls() #enable security
session.login(sender_address, sender_pass) #login with mail_id and password
text = message.as_string()
session.sendmail(sender_address, receiver_address, text)
session.quit()
print('Mail Sent')