json.array!(@questions) do |question|
  json.extract! question, :id, :options, :question, :geo, :user_id
  json.url question_url(question, format: :json)
end
