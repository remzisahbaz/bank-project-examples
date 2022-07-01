FROM node:15.13-alpine
WORKDIR /demo_frontend
ENV PATH ="./node_modules/.bin:$PATH"
COPY . .
RUN npm run start
#EXPOSE 3000
#CMD ["npm","start"]