'use client'

import { useState } from 'react'
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs"
import { ScrollArea } from "@/components/ui/scroll-area"
import { BookOpen, Monitor, Search } from 'lucide-react'

export default function Component() {
  const [searchTerm, setSearchTerm] = useState('')

  const modules = {
    ict: [
      { id: 'ict1', title: 'Introduction to Programming', description: 'Learn the basics of programming concepts and syntax.' },
      { id: 'ict2', title: 'Web Development Fundamentals', description: 'Understand the core technologies of web development: HTML, CSS, and JavaScript.' },
      { id: 'ict3', title: 'Database Management', description: 'Explore database design, SQL, and data manipulation techniques.' },
      { id: 'ict4', title: 'Networking Essentials', description: 'Learn about network protocols, topologies, and troubleshooting.' },
    ],
    css: [
      { id: 'css1', title: 'Computer Hardware Basics', description: 'Understand the components and architecture of modern computers.' },
      { id: 'css2', title: 'Operating Systems', description: 'Learn about different OS types, their functions, and management.' },
      { id: 'css3', title: 'System Troubleshooting', description: 'Develop skills to diagnose and resolve common system issues.' },
      { id: 'css4', title: 'Network Administration', description: 'Explore network setup, security, and maintenance practices.' },
    ],
  }

  const filteredModules = (strand) => 
    modules[strand].filter(module => 
      module.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
      module.description.toLowerCase().includes(searchTerm.toLowerCase())
    )

  return (
    <div className="container mx-auto p-4 max-w-4xl">
      <header className="text-center mb-8">
        <h1 className="text-4xl font-bold mb-2">DISQUID</h1>
        <p className="text-xl text-muted-foreground">Digital ICT Student Quick Information Database</p>
      </header>

      <div className="mb-6">
        <div className="relative">
          <Search className="absolute left-2 top-1/2 transform -translate-y-1/2 text-muted-foreground" />
          <Input
            type="search"
            placeholder="Search modules..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
            className="pl-10"
          />
        </div>
      </div>

      <Tabs defaultValue="ict" className="w-full">
        <TabsList className="grid w-full grid-cols-2">
          <TabsTrigger value="ict">
            <Monitor className="mr-2 h-4 w-4" />
            ICT Strand
          </TabsTrigger>
          <TabsTrigger value="css">
            <BookOpen className="mr-2 h-4 w-4" />
            CSS Strand
          </TabsTrigger>
        </TabsList>
        <TabsContent value="ict">
          <Card>
            <CardHeader>
              <CardTitle>ICT Modules</CardTitle>
              <CardDescription>Explore Information and Communications Technology topics</CardDescription>
            </CardHeader>
            <CardContent>
              <ScrollArea className="h-[400px] w-full rounded-md border p-4">
                {filteredModules('ict').map(module => (
                  <Card key={module.id} className="mb-4">
                    <CardHeader>
                      <CardTitle>{module.title}</CardTitle>
                      <CardDescription>{module.description}</CardDescription>
                    </CardHeader>
                    <CardContent>
                      <Button>Start Learning</Button>
                    </CardContent>
                  </Card>
                ))}
              </ScrollArea>
            </CardContent>
          </Card>
        </TabsContent>
        <TabsContent value="css">
          <Card>
            <CardHeader>
              <CardTitle>CSS Modules</CardTitle>
              <CardDescription>Discover Computer Systems Servicing materials</CardDescription>
            </CardHeader>
            <CardContent>
              <ScrollArea className="h-[400px] w-full rounded-md border p-4">
                {filteredModules('css').map(module => (
                  <Card key={module.id} className="mb-4">
                    <CardHeader>
                      <CardTitle>{module.title}</CardTitle>
                      <CardDescription>{module.description}</CardDescription>
                    </CardHeader>
                    <CardContent>
                      <Button>Start Learning</Button>
                    </CardContent>
                  </Card>
                ))}
              </ScrollArea>
            </CardContent>
          </Card>
        </TabsContent>
      </Tabs>
    </div>
  )
}
