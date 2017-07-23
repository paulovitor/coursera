# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)

TodoItem.destroy_all
TodoList.destroy_all
Profile.destroy_all
User.destroy_all

user1 = User.create username: "Fiorina", password_digest: "Fiorina"
Profile.create gender: "female", birth_year: 1954, first_name: "Carly", last_name: "Fiorina", user: user1

todoList1 = TodoList.create list_name: "Carly list", list_due_date: Date.today, user: user1
(0..4).each do |i|
    TodoItem.create due_date: Date.today + rand(0..100).day, title: "Title #{i}", description: "Description #{i}", completed: false, todo_list: todoList1
end


user2 = User.create username: "Trump", password_digest: "Trump"
Profile.create gender: "male", birth_year: 1946, first_name: "Donald", last_name: "Trump", user: user2

todoList2 = TodoList.create list_name: "Donald list", list_due_date: Date.today, user: user2
(0..4).each do |i|
    TodoItem.create due_date: Date.today + rand(0..100).day, title: "Title #{i}", description: "Description #{i}", completed: false, todo_list: todoList2
end


user3 = User.create username: "Carson", password_digest: "Carson"
Profile.create gender: "male", birth_year: 1951, first_name: "Ben", last_name: "Carson", user: user3

todoList3 = TodoList.create list_name: "Ben list", list_due_date: Date.today, user: user3
(0..4).each do |i|
    TodoItem.create due_date: Date.today + rand(0..100).day, title: "Title #{i}", description: "Description #{i}", completed: false, todo_list: todoList3
end


user4 = User.create username: "Clinton", password_digest: "Clinton"
Profile.create gender: "female", birth_year: 1947, first_name: "Hillary", last_name: "Clinton", user: user4

todoList4 = TodoList.create list_name: "Hillary list", list_due_date: Date.today, user: user4
(0..4).each do |i|
    TodoItem.create due_date: Date.today + rand(0..100).day, title: "Title #{i}", description: "Description #{i}", completed: false, todo_list: todoList4
end
